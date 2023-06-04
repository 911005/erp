package com.eleadmin.RawMaterialManagement.material.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 *
 * @author EleAdmin
 * @since 2023-05-31 09:31:17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Material对象", description = "")
public class Material implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "采购协议编号")
    @TableField("purchaseAgreementNum")
    private String purchaseagreementnum;

    @ApiModelProperty(value = "往来单位")
    @TableField("correspondenceUnit")
    private String correspondenceunit;

    @ApiModelProperty(value = "供应方式")
    @TableField("supplyMethod")
    private String supplymethod;

    @ApiModelProperty(value = "联系人")
    @TableField("contacts")
    private String contacts;

    @ApiModelProperty(value = "采购时间")
    @TableField("procurementTime")
    private Date procurementtime;

    @ApiModelProperty(value = "交货地点")
    @TableField("deliveryPlace")
    private String deliveryplace;

    @ApiModelProperty(value = "供应原材料")
    @TableField("supplyMaterials")
    private String supplymaterials;

    @ApiModelProperty(value = "平台原材料")
    @TableField("platformMaterials")
    private String platformmaterials;

    @ApiModelProperty(value = "计价单位")
    @TableField("pricingUnit")
    private String pricingunit;

    @ApiModelProperty(value = "转换系数")
    @TableField("conversionCoefficient")
    private String conversioncoefficient;

    @ApiModelProperty(value = "计划数量")
    @TableField("plannedQuantity")
    private String plannedquantity;

    @ApiModelProperty(value = "单价")
    @TableField("unitPrice")
    private Double unitprice;

    @ApiModelProperty(value = "制定时间")
    @TableField("dgnTime")
    private Date dgntime;

    @ApiModelProperty(value = "状态")
    @TableField("state")
    private String state;


    @ApiModelProperty(value = "联系人电话")
    @TableField("number")
    private String number;

    private Integer tenantId;

}
