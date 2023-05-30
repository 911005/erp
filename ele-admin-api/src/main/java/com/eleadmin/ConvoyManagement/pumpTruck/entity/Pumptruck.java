package com.eleadmin.ConvoyManagement.pumpTruck.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 *
 * @author EleAdmin
 * @since 2023-05-13 17:32:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Pumptruck对象", description = "")
public class Pumptruck implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("pumpTruckId")
    private String pumptruckid;

    @TableField("pumpTruckNumber")
    private String pumptrucknumber;

    @TableField("carIdenNumber")
    private String caridennumber;

    @TableField("GPSIdenNumber")
    private String gpsidennumber;

    @TableField("pumpingHeight")
    private String pumpingheight;

    private String subunit;

    @TableField("personInCharge")
    private String personincharge;

    private String remarks;

    private String status;

}
