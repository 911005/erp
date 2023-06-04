package com.eleadmin.RawMaterialManagement.supplier.param;

import com.baomidou.mybatisplus.annotation.TableField;
import com.eleadmin.common.core.annotation.QueryField;
import com.eleadmin.common.core.annotation.QueryType;
import com.eleadmin.common.core.web.BaseParam;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询参数
 *
 * @author EleAdmin
 * @since 2023-06-03 22:38:26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "SupplierParam对象", description = "查询参数")
public class SupplierParam extends BaseParam {
    private static final long serialVersionUID = 1L;

    @QueryField(type = QueryType.EQ)
    private Integer id;

    @ApiModelProperty(value = "供应商名称")
    private String suppliername;

    @ApiModelProperty(value = "供应商类别")
    private String suppliertype;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "地址")
    private String supplieraddress;

    @ApiModelProperty(value = "采购员")
    @TableField("saleman")
    private String saleman;

//    @ApiModelProperty(value = "用户昵称")
//    private String nickname;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "传真号")
    @QueryField(type = QueryType.EQ)
    private Integer faxnumber;

    @ApiModelProperty(value = "邮编")
    private String zipcode;

    @ApiModelProperty(value = "法人代表")
    private String legalrepresentative;

    @ApiModelProperty(value = "电子邮箱")
    private String email;

    @ApiModelProperty(value = "纳税号")
    @QueryField(type = QueryType.EQ)
    private Integer taxidnumber;

    @ApiModelProperty(value = "供应原材料")
    private String materialid;

    @ApiModelProperty(value = "状态")
    private String status;


    @ApiModelProperty(value = "平台原材料名称")
    @TableField("platformMaterialName")
    private String platformmaterialname;

    @ApiModelProperty(value = "供应原材料名称")
    @TableField("supplyMaterialName")
    private String supplymaterialname;

    @ApiModelProperty(value = "规格型号")
    private String specifications;

}
