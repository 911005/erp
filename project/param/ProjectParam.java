package com.eleadmin.SalesManagement.project.param;


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
 * @since 2023-05-17 16:03:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "ProjectParam对象", description = "查询参数")
public class ProjectParam extends BaseParam {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "projectid")
    @QueryField(type = QueryType.EQ)
    private Integer projectid;

    @ApiModelProperty(value = "工程名称")
    private String projectname;

    @ApiModelProperty(value = "工程进度")
    private String projectprogress;

    @ApiModelProperty(value = "工程类别")
    private String projecttype;

    @ApiModelProperty(value = "工程级别")
    private String projectlevel;

    @ApiModelProperty(value = "浇筑方量")
    private String poursquare;

    @ApiModelProperty(value = "工程地址")
    private String projectaddress;

    @ApiModelProperty(value = "运输距离")
    private Double transportationdistance;

    @ApiModelProperty(value = "建设单位")
    private String construction;

    @ApiModelProperty(value = "施工单位")
    private String constructionunit;

    @ApiModelProperty(value = "客户名称")
    private String customername;

    @ApiModelProperty(value = "预计开工日期")
    private String startdate;

    @ApiModelProperty(value = "状态")
    private String state;

}
