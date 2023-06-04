package com.eleadmin.ProductionCenter.productiontask.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 *
 * @author EleAdmin
 * @since 2023-06-03 15:41:20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Productiontasks对象", description = "")
public class Productiontasks implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "missonId", type = IdType.AUTO)
    private Integer missonid;

    @ApiModelProperty(value = "生产任务编号")
    private String mnumber;

    @ApiModelProperty(value = "状态")
    private String mstatus;

    @ApiModelProperty(value = "发货进度")
    @TableField("shipmentProgress")
    private String shipmentprogress;

    @ApiModelProperty(value = "销售订单Id，外键")
    @TableField("orderId")
    private Integer orderid;

    @ApiModelProperty(value = "制单时间")
    @TableField("orderTime")
    private Date ordertime;

    @ApiModelProperty(value = "任务级别")
    @TableField("taskLevel")
    private String tasklevel;

    @ApiModelProperty(value = "开盘设定")
    @TableField("openSettings")
    private String opensettings;

    @ApiModelProperty(value = "任务备注")
    private String remarks;

    @ApiModelProperty(value = "业务员")
    private String salesman;

    private Integer tenantId;

}
