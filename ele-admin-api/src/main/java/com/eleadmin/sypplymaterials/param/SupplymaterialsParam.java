package com.eleadmin.sypplymaterials.param;

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
 * @since 2023-04-26 15:59:35
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "SupplymaterialsParam对象", description = "查询参数")
public class SupplymaterialsParam extends BaseParam {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "原材料id")
    @QueryField(type = QueryType.EQ)
    private Integer meterialid;

    @ApiModelProperty(value = "平台原材料名称")
    private String platformmaterialname;

    @ApiModelProperty(value = "供应原材料名称")
    private String supplymaterialname;

    @ApiModelProperty(value = "规格型号")
    private String specifications;

}
