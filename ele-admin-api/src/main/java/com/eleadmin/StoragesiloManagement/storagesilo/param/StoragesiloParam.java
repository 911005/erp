package com.eleadmin.StoragesiloManagement.storagesilo.param;

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
 * @since 2023-05-14 11:24:50
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "StoragesiloParam对象", description = "查询参数")
public class StoragesiloParam extends BaseParam {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @QueryField(type = QueryType.EQ)
    private Integer id;

    @ApiModelProperty(value = "储料仓名称")
    private String storagesiloname;

    @ApiModelProperty(value = "储存类别")
    private String storagesliotype;

    @ApiModelProperty(value = "容量")
    private String volume;

    @ApiModelProperty(value = "预警上限")
    private String warnuplimit;

    @ApiModelProperty(value = "预警下限")
    private String warndpwnlimit;

    @ApiModelProperty(value = "安全容量")
    private String safevolume;

    @ApiModelProperty(value = "库管员")
    private String username;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "状态")
    private String storagesilostate;

}
