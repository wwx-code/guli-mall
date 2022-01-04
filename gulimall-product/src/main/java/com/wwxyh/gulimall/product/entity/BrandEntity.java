package com.wwxyh.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import com.wwxyh.common.valid.AddGroup;
import com.wwxyh.common.valid.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;

/**
 * 品牌
 * 
 * @author wwx
 * @email 
 * @date 2021-11-20 23:18:56
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	@Null(message = "新增品牌不能指定id")
	@NotNull(message = "更新品牌必须指定id")
	private Long brandId;

	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名不能为空")
	private String name;

	/**
	 * 品牌logo地址
	 */
	@URL(message = "logo地址不合法")
	private String logo;

	/**
	 * 介绍
	 */
	private String descript;

	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	private Integer showStatus;

	/**
	 * 检索首字母
	 */
	@Pattern(regexp = "^[a-zA-z]$", message = "检索首字母必须是一个字母")
	private String firstLetter;

	/**
	 * 排序
	 */
	@Min(value = 0, message = "排序必须大于等于0")
	private Integer sort;

}
