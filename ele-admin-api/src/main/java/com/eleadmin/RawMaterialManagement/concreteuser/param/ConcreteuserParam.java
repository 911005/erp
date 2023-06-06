package com.eleadmin.RawMaterialManagement.concreteuser.param;

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
 * @since 2023-06-05 11:45:54
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "ConcreteuserParam对象", description = "查询参数")
public class ConcreteuserParam extends BaseParam {
    private static final long serialVersionUID = 1L;

    @QueryField(type = QueryType.EQ)
    private Integer id;

    @ApiModelProperty(value = "单位名称")
    private String unitname;

    @ApiModelProperty(value = "单位类型")
    private String unittype;

    @ApiModelProperty(value = "联系电话")
    private String pnumber;

    @ApiModelProperty(value = "联系地址")
    private String address;

    @ApiModelProperty(value = "业务员")
    private String operator;

    @ApiModelProperty(value = "状态")
    private String state;

    @ApiModelProperty(value = "备注")
    private String remarks;

}
