package com.eleadmin.SalesManagement.customer.param;

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
 * @since 2023-04-26 15:35:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "CustomerParam对象", description = "查询参数")
public class CustomerParam extends BaseParam {
    private static final long serialVersionUID = 1L;

    @QueryField(type = QueryType.EQ)
    private Integer id;

    @ApiModelProperty(value = "单位名称")
    private String unitname;

    @ApiModelProperty(value = "单位类别")
    private String unittype;

    @ApiModelProperty(value = "法人代表")
    private String legalrepresentative;

    @ApiModelProperty(value = "联系电话")
    private String unitphone;

    @ApiModelProperty(value = "传真号")
    private String faxnumber;

    @ApiModelProperty(value = "电子邮箱")
    private String unitemail;

    @ApiModelProperty(value = "联系地址")
    private String unitaddress;

    @ApiModelProperty(value = "邮编")
    private String zipcode;

    @ApiModelProperty(value = "业务员")
    private String salesman;

    @ApiModelProperty(value = "纳税号")
    private String ratepayingnumber;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "备注")
    private String remarks;

}
