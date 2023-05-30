package com.eleadmin.ConvoyManagement.tanker.param;

import com.eleadmin.common.core.annotation.QueryField;
import com.eleadmin.common.core.annotation.QueryType;
import com.eleadmin.common.core.web.BaseParam;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 查询参数
 *
 * @author EleAdmin
 * @since 2023-05-13 15:42:42
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "TankerParam对象", description = "查询参数")
public class TankerParam extends BaseParam {
    private static final long serialVersionUID = 1L;

    @QueryField(type = QueryType.EQ)
    private Integer id;

    @QueryField(type = QueryType.EQ)
    private Integer tankcarid;

    @QueryField(type = QueryType.EQ)
    private Integer tankcarnumber;

    @QueryField(type = QueryType.EQ)
    private Integer gpsidennumber;

    private String initialtare;

    private String currenttare;

    private String subunit;

    private String personincharge;

    private String remarks;

}
