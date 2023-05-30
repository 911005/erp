package com.eleadmin.SalesManagement.salesContract.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 *
 * @author EleAdmin
 * @since 2023-05-29 17:25:40
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Salescontract对象", description = "")
public class Salescontract implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "salesContractId", type = IdType.AUTO)
    private Integer salescontractid;

    @ApiModelProperty(value = "合同编号")
    private String number;

    @ApiModelProperty(value = "合同类别")
    @TableField("contraType")
    private String contratype;

    @ApiModelProperty(value = "合同金额")
    @TableField("contractAmount")
    private String contractamount;

    @ApiModelProperty(value = "签订时间")
    @TableField("signingTime")
    private Date signingtime;

    @ApiModelProperty(value = "客户id，外键")
    @TableField("customerId")
    private Integer customerid;

    @ApiModelProperty(value = "工程id，外键")
    @TableField("projectId")
    private Integer projectid;

    @ApiModelProperty(value = "供货期-开始")
    @TableField("supplyPeriodStart")
    private Date supplyperiodstart;

    @ApiModelProperty(value = "供货期-结束")
    @TableField("supplyPeriodEnd")
    private Date supplyperiodend;

    @ApiModelProperty(value = "制单人")
    private String creator;

    private Integer tenantId;

}
