package com.eleadmin.BasicInformationManagement.production.param;

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
 * @since 2023-05-28 16:40:05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "ProductionParam对象", description = "查询参数")
public class ProductionParam extends BaseParam {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "节点ID，主键")
    @QueryField(type = QueryType.EQ)
    private Integer propertyid;

    @ApiModelProperty(value = "节点名称")
    private String propertyname;

    @ApiModelProperty(value = "父节点ID，外键关联propertyId")
    @QueryField(type = QueryType.EQ)
    private Integer parentid;

    @ApiModelProperty(value = "节点属性")
    private String subproperty;

    @ApiModelProperty(value = "状态")
    private String propertystate;

}
