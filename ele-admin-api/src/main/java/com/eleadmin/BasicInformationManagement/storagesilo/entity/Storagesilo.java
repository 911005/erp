package com.eleadmin.BasicInformationManagement.storagesilo.entity;

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
 * @since 2023-05-14 11:24:51
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Storagesilo对象", description = "")
public class Storagesilo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "储料仓名称")
    @TableField("storagesiloName")
    private String storagesiloname;

    @ApiModelProperty(value = "储存类别")
    @TableField("storageslioType")
    private String storagesliotype;

    @ApiModelProperty(value = "容量")
    private String volume;

    @ApiModelProperty(value = "预警上限")
    @TableField("warnupLimit")
    private String warnuplimit;

    @ApiModelProperty(value = "预警下限")
    @TableField("warndpwnLimit")
    private String warndpwnlimit;

    @ApiModelProperty(value = "安全容量")
    @TableField("safeVolume")
    private String safevolume;

    @ApiModelProperty(value = "库管员")
    private String username;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "状态")
    @TableField("storagesiloState")
    private String storagesilostate;

    private Integer tenantId;

}
