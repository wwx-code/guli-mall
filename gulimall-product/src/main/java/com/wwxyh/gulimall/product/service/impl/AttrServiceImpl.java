package com.wwxyh.gulimall.product.service.impl;

import com.wwxyh.common.constant.ProductConstant;
import com.wwxyh.gulimall.product.dao.AttrAttrgroupRelationDao;
import com.wwxyh.gulimall.product.dao.AttrGroupDao;
import com.wwxyh.gulimall.product.dao.CategoryDao;
import com.wwxyh.gulimall.product.entity.AttrAttrgroupRelationEntity;
import com.wwxyh.gulimall.product.entity.AttrGroupEntity;
import com.wwxyh.gulimall.product.entity.CategoryEntity;
import com.wwxyh.gulimall.product.vo.AttrRespVo;
import com.wwxyh.gulimall.product.vo.AttrVo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wwxyh.common.utils.PageUtils;
import com.wwxyh.common.utils.Query;

import com.wwxyh.gulimall.product.dao.AttrDao;
import com.wwxyh.gulimall.product.entity.AttrEntity;
import com.wwxyh.gulimall.product.service.AttrService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

    @Resource
    private AttrAttrgroupRelationDao relationDao;

    @Resource
    private AttrGroupDao attrGroupDao;

    @Resource
    private CategoryDao categoryDao;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                new QueryWrapper<AttrEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveAttr(AttrVo attr) {
        AttrEntity attrEntity = new AttrEntity();
        BeanUtils.copyProperties(attr,attrEntity);
        //1、保存基本数据
        this.save(attrEntity);

        //2、保存关联关系
        //判断类型，如果是基本属性就设置分组id
//        if (attr.getAttrType() == ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode() && attr.getAttrGroupId() != null) {
            AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();
            relationEntity.setAttrGroupId(attr.getAttrGroupId());
            relationEntity.setAttrId(attrEntity.getAttrId());
            relationDao.insert(relationEntity);
//        }
    }

    @Override
    public PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId, String attrType) {
        QueryWrapper<AttrEntity> queryWrapper = new QueryWrapper<AttrEntity>()
                .eq("attr_type","base".equalsIgnoreCase(attrType) ?
                        ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode() : ProductConstant.AttrEnum.ATTR_TYPE_SALE.getCode());

        //根据catelogId查询信息
        if (catelogId != 0) {
            queryWrapper.eq("catelog_id",catelogId);
        }

        String key = (String) params.get("key");
        if (!StringUtils.isEmpty(key)) {
            //attr_id attr_name
            queryWrapper.and((wrapper) -> {
                wrapper.eq("attr_id",key).or().like("attr_name",key);
            });
        }

        IPage<AttrEntity> page = this.page(
                new Query<AttrEntity>().getPage(params),
                queryWrapper
        );

        PageUtils pageUtils = new PageUtils(page);
        List<AttrEntity> records = page.getRecords();

        List<AttrRespVo> respVos = records.stream().map((attrEntity) -> {
            AttrRespVo attrRespVo = new AttrRespVo();
            BeanUtils.copyProperties(attrEntity, attrRespVo);

            //设置分类和分组的名字
            if ("base".equalsIgnoreCase(attrType)) {
                AttrAttrgroupRelationEntity relationEntity =
                        relationDao.selectOne(new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id",attrEntity.getAttrId()));
                if (relationEntity != null && relationEntity.getAttrGroupId() != null) {
                    AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(relationEntity.getAttrGroupId());
                    attrRespVo.setGroupName(attrGroupEntity.getAttrGroupName());
                }

            }

            CategoryEntity categoryEntity = categoryDao.selectById(attrEntity.getCatelogId());
            if (categoryEntity != null) {
                attrRespVo.setCatelogName(categoryEntity.getName());

            }
            return attrRespVo;
        }).collect(Collectors.toList());

        pageUtils.setList(respVos);
        return pageUtils;
    }

}