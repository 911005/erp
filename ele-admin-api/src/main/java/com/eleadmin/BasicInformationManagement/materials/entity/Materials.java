package com.eleadmin.BasicInformationManagement.materials.entity;

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
 * @since 2023-05-29 16:16:43
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Materials对象", description = "")
public class Materials implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String rawname;

    private int caregoryid;

    private String model;

    @TableField("unitOfMeasurement")
    private String unitofmeasurement;

    private String status;

}
