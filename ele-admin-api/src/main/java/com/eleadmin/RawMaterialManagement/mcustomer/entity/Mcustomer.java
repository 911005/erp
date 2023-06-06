package com.eleadmin.RawMaterialManagement.mcustomer.entity;

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
 * @since 2023-06-04 21:55:35
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Mcustomer对象", description = "")
public class Mcustomer implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "单位名称")
    @TableField("unitName")
    private String unitname;

    @ApiModelProperty(value = "单位类型")
    @TableField("unitType")
    private String unittype;

    @ApiModelProperty(value = "电话号码")
    private String pnumber;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "业务员")
    private String operator;

    @ApiModelProperty(value = "状态")
    private String state;

    @ApiModelProperty(value = "备注")
    private String remarks;

    private Integer tenantId;
}
