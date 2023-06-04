package com.eleadmin.ProductionCenter.productiontask.param;

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
 * @since 2023-06-03 15:41:20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(value = "ProductiontasksParam对象", description = "查询参数")
public class ProductiontasksParam extends BaseParam {
    private static final long serialVersionUID = 1L;

    @QueryField(type = QueryType.EQ)
    private Integer missonid;

    @ApiModelProperty(value = "生产任务编号")
    private String mnumber;

    @ApiModelProperty(value = "状态")
    private String mstatus;

    @ApiModelProperty(value = "计划浇筑时间")
    private String pouringdate;
    @ApiModelProperty(value = "混凝土标记")
    private String concretemarkings;

    @ApiModelProperty(value = "客户名称")
    @TableField("customerName")
    private String customername;

    @ApiModelProperty(value = "工程名称")
    @TableField("projectName")
    private String projectname;

    @ApiModelProperty(value = "工程地址")
    @TableField("projectAddress")
    private String projectaddress;



    @ApiModelProperty(value = "发货进度")
    private String shipmentprogress;

    @ApiModelProperty(value = "销售订单Id，外键")
    @QueryField(type = QueryType.EQ)
    private Integer orderid;

    private String ordernumber;

    @ApiModelProperty(value = "制单时间")
    private Date ordertime;

    @ApiModelProperty(value = "任务级别")
    private String tasklevel;

    @ApiModelProperty(value = "开盘设定")
    private String opensettings;

    @ApiModelProperty(value = "任务备注")
    private String remarks;

    @ApiModelProperty(value = "业务员")
    private String salesman;


    private String pouringmethod;
    private Integer plannedsqueravolume;

    //混凝土标记
    private String strengthlevel;
    private String slump;
    private String impermeabilitylevel;
    private String frostresistancelevel;
    private String sulfateresistancelevel;
    private String chlorideionresistancelevel;
    private String admixture;
    private String specialrawmaterials;
}
