package com.eleadmin.RawMaterialManagement.material.param;

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
 * @since 2023-05-31 09:31:17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "MaterialParam对象", description = "查询参数")
public class MaterialParam extends BaseParam {
    private static final long serialVersionUID = 1L;

    @QueryField(type = QueryType.EQ)
    private Integer id;

    @ApiModelProperty(value = "采购协议编号")
    private String purchaseagreementnum;

    @ApiModelProperty(value = "往来单位")
    private String correspondenceunit;

    @ApiModelProperty(value = "供应方式")
    private String supplymethod;

    @ApiModelProperty(value = "联系人")
    private String contacts;

    @ApiModelProperty(value = "采购时间")
    private String procurementtime;

    @ApiModelProperty(value = "交货地点")
    private String deliveryplace;

    @ApiModelProperty(value = "供应原材料")
    private String supplymaterials;

    @ApiModelProperty(value = "平台原材料")
    private String platformmaterials;

    @ApiModelProperty(value = "计价单位")
    private String pricingunit;

    @ApiModelProperty(value = "转换系数")
    private String conversioncoefficient;

    @ApiModelProperty(value = "计划数量")
    private String plannedquantity;

    @ApiModelProperty(value = "单价")
    private Double unitprice;

    @ApiModelProperty(value = "制定时间")
    private String dgntime;

    @ApiModelProperty(value = "状态")
    private String state;

    @ApiModelProperty(value = "联系人电话")
    private String number;

}
