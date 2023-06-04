package com.eleadmin.SalesManagement.order.param;

import com.baomidou.mybatisplus.annotation.TableField;
import com.eleadmin.common.core.annotation.QueryField;
import com.eleadmin.common.core.annotation.QueryType;
import com.eleadmin.common.core.web.BaseParam;
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
 * @since 2023-05-31 15:47:21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "OrderParam对象", description = "查询参数")
public class OrderParam extends BaseParam {
    private static final long serialVersionUID = 1L;

    @QueryField(type = QueryType.EQ)
    private Integer id;

    private String ordernumber;

    private String orderdate;

    private String status;

    @QueryField(type = QueryType.EQ)
    private Integer salecontractid;


    private String pouringdate;

    private String concretemarkings;

    private String pouringmethod;

    private int plannedsqueravolume;

    private String salesman;

    private String remarks;

    @ApiModelProperty(value = "合同编号")
    private String number;

    @ApiModelProperty(value = "合同类别")
    @TableField("contraType")
    private String contratype;

    @ApiModelProperty(value = "签订时间")
    @TableField("signingTime")
    private Date signingtime;

    @ApiModelProperty(value = "客户名称")
    @TableField("customerName")
    private String customername;

    @ApiModelProperty(value = "工程名称")
    @TableField("projectName")
    private String projectname;

    @ApiModelProperty(value = "工程地址")
    @TableField("projectAddress")
    private String projectaddress;

    @ApiModelProperty(value = "施工单位")
    @TableField("constructionUnit")
    private String constructionunit;

    @ApiModelProperty(value = "制单人")
    private String creator;

    @ApiModelProperty(value = "强度等级")
    @TableField("Strengthlevel")
    private String strengthlevel;

    @ApiModelProperty(value = "坍落度")
    @TableField("Slump")
    private String slump;

    @ApiModelProperty(value = "抗渗等级")
    @TableField("Impermeabilitylevel")
    private String impermeabilitylevel;

    @ApiModelProperty(value = "抗冻等级")
    @TableField("FrostResistancelevel")
    private String frostresistancelevel;

    @ApiModelProperty(value = "抗硫酸盐等级")
    @TableField("SulfateResistancelevel")
    private String sulfateresistancelevel;

    @ApiModelProperty(value = "抗氯离子等级")
    @TableField("Chlorideionresistancelevel")
    private String chlorideionresistancelevel;

    @ApiModelProperty(value = "外加剂")
    @TableField("Admixture")
    private String admixture;

    @ApiModelProperty(value = "特殊原材料")
    @TableField("Specialrawmaterials")
    private String specialrawmaterials;

}
