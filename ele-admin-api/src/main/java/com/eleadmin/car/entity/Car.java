package com.eleadmin.car.entity;

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
 * @since 2023-05-14 15:37:43
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Car对象", description = "")
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("carId")
    private String carid;

    private String status;

    @TableField("carNumber")
    private String carnumber;

    @TableField("carIdenNumber")
    private String caridennumber;

    @TableField("GPSIdenNumber")
    private String gpsidennumber;

    @TableField("Tare")
    private float tare;

    private String subunit;

    @TableField("personInCharge")
    private String personincharge;

    private String remarks;

}
