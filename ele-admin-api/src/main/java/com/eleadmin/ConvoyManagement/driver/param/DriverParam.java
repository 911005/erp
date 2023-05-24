package com.eleadmin.ConvoyManagement.driver.param;

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
 * @since 2023-05-13 17:46:29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "DriverParam对象", description = "查询参数")
public class DriverParam extends BaseParam {
    private static final long serialVersionUID = 1L;

    @QueryField(type = QueryType.EQ)
    private Integer id;

    @ApiModelProperty(value = "工号")
    private String jobnumber;

    @ApiModelProperty(value = "司机姓名")
    private String drivername;

    @ApiModelProperty(value = "司机类型")
    private String drivertype;

    @ApiModelProperty(value = "司机类别")
    private String drivercategory;

    @ApiModelProperty(value = "联系电话")
    private String driverphone;

    @ApiModelProperty(value = "司机状态")
    private String driverstate;

}
