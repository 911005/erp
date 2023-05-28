package com.eleadmin.ConvoyManagement.driver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2023-05-13 17:46:30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Driver对象", description = "")
public class Driver implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "工号")
    @TableField("jobNumber")
    private String jobnumber;

    @ApiModelProperty(value = "司机姓名")
    @TableField("driverName")
    private String drivername;

    @ApiModelProperty(value = "司机类型")
    @TableField("driverType")
    private String drivertype;

    @ApiModelProperty(value = "司机类别")
    @TableField("driverCategory")
    private String drivercategory;

    @ApiModelProperty(value = "联系电话")
    @TableField("driverPhone")
    private String driverphone;

    @ApiModelProperty(value = "司机状态")
    @TableField("driverState")
    private String driverstate;


}
