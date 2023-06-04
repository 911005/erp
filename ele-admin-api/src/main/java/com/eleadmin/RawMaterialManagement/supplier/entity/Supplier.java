package com.eleadmin.RawMaterialManagement.supplier.entity;

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
 * @since 2023-06-03 22:38:26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Supplier对象", description = "")
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "供应商名称")
    @TableField("supplierName")
    private String suppliername;

    @ApiModelProperty(value = "供应商类别")
    @TableField("supplierType")
    private String suppliertype;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "地址")
    @TableField("supplierAddress")
    private String supplieraddress;

    @ApiModelProperty(value = "采购员")
    @TableField("saleman")
    private String saleman;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "传真号")
    @TableField("faxNumber")
    private Integer faxnumber;

    @ApiModelProperty(value = "邮编")
    @TableField("zipCode")
    private String zipcode;

    @ApiModelProperty(value = "法人代表")
    @TableField("legalRepresentative")
    private String legalrepresentative;

    @ApiModelProperty(value = "电子邮箱")
    private String email;

    @ApiModelProperty(value = "纳税号")
    @TableField("taxIDnumber")
    private Integer taxidnumber;

    @ApiModelProperty(value = "供应原材料id")
    @TableField("materialId")
    private String materialid;

    @ApiModelProperty(value = "状态")
    private String status;

}
