package com.eleadmin.tanker.entity;

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
 * @since 2023-05-13 15:42:42
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Tanker对象", description = "")
public class Tanker implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("tankCarId")
    private String tankcarid;

    @TableField("tankCarNumber")
    private Integer tankcarnumber;

    @TableField("carIdenNumber")
    private String caridennumber;

    @TableField("GPSIdenNumber")
    private String gpsidennumber;

    @TableField("initialTare")
    private float initialtare;

    @TableField("currentTare")
    private float currenttare;

    private String subunit;

    @TableField("personInCharge")
    private String personincharge;

    private String remarks;

    private String status;

}
