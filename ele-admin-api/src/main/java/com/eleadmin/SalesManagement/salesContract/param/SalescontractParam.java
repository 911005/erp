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

import java.util.Date;

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
    private Date signingtime;

//    @ApiModelProperty(value = "客户id，外键")
//    @QueryField(type = QueryType.EQ)
//    private Integer customerid;

    @ApiModelProperty(value = "工程id，外键")
    @QueryField(type = QueryType.EQ)
    private Integer projectid;

    @ApiModelProperty(value = "供货期-开始")
    private Date supplyperiodstart;

    @ApiModelProperty(value = "供货期-结束")
    private Date supplyperiodend;

    @ApiModelProperty(value = "制单人")
    private String creator;




    @ApiModelProperty(value = "客户名称")
    @TableField("customerName")
    private String customername;

    @ApiModelProperty(value = "工程名称")
    @TableField("projectName")
    private String projectname;

    @ApiModelProperty(value = "施工单位")
    @TableField("constructionUnit")
    private String constructionunit;

    @ApiModelProperty(value = "建设单位")
    @TableField("construction")
    private String construction;

    @ApiModelProperty(value = "浇筑方量")
    @TableField("pourSquare")
    private String poursquare;

    @ApiModelProperty(value = "工程地址")
    @TableField("projectAddress")
    private String projectaddress;

    @ApiModelProperty(value = "运输距离")
    @TableField("transportationDistance")
    private Double transportationdistance;

}
