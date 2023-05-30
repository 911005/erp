package com.eleadmin.SalesManagement.salesContract.param;

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
 * @since 2023-05-29 17:25:40
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "SalescontractParam对象", description = "查询参数")
public class SalescontractParam extends BaseParam {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @QueryField(type = QueryType.EQ)
    private Integer salescontractid;

    @ApiModelProperty(value = "合同编号")
    private String number;

    @ApiModelProperty(value = "合同类别")
    private String contratype;

    @ApiModelProperty(value = "合同金额")
    private String contractamount;

    @ApiModelProperty(value = "签订时间")
    private String signingtime;

    @ApiModelProperty(value = "客户id，外键")
    @QueryField(type = QueryType.EQ)
    private Integer customerid;

    @ApiModelProperty(value = "工程id，外键")
    @QueryField(type = QueryType.EQ)
    private Integer projectid;

    @ApiModelProperty(value = "供货期-开始")
    private String supplyperiodstart;

    @ApiModelProperty(value = "供货期-结束")
    private String supplyperiodend;

    @ApiModelProperty(value = "制单人")
    private String creator;




    @ApiModelProperty(value = "单位名称")
    @TableField("unitName")
    private String unitname;

    @ApiModelProperty(value = "工程名称")
    @TableField("projectName")
    private String projectname;

    @ApiModelProperty(value = "工程地址")
    @TableField("projectAddress")
    private String projectaddress;

    @ApiModelProperty(value = "运输距离")
    @TableField("transportationDistance")
    private Double transportationdistance;

}
