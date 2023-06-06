package com.eleadmin.RawMaterialManagement.concreteuser.entity;

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
 * @since 2023-06-05 11:45:54
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Concreteuser对象", description = "")
public class Concreteuser implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "单位名称")
    @TableField("unitName")
    private String unitname;

    @ApiModelProperty(value = "单位类型")
    @TableField("unitType")
    private String unittype;

    @ApiModelProperty(value = "联系电话")
    private String pnumber;

    @ApiModelProperty(value = "联系地址")
    private String address;

    @ApiModelProperty(value = "业务员")
    private String operator;

    @ApiModelProperty(value = "状态")
    private String state;

    @ApiModelProperty(value = "备注")
    private String remarks;

    private Integer tenantId;

}
