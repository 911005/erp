package com.eleadmin.sypplymaterials.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 *
 * @author EleAdmin
 * @since 2023-04-26 15:59:35
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Supplymaterials对象", description = "")
public class Supplymaterials implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "原材料id")
    @TableId(value = "materialId", type = IdType.AUTO)
    private Integer materialid;

    @ApiModelProperty(value = "平台原材料名称")
    @TableField("platformMaterialName")
    private String platformmaterialname;

    @ApiModelProperty(value = "供应原材料名称")
    @TableField("supplyMaterialName")
    private String supplymaterialname;

    @ApiModelProperty(value = "规格型号")
    private String specifications;


}
