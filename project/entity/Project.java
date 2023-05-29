package com.eleadmin.SalesManagement.project.entity;

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
 * @since 2023-05-17 16:03:03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Project对象", description = "")
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "projectId", type = IdType.AUTO)
    private Integer projectid;

    @ApiModelProperty(value = "工程名称")
    @TableField("projectName")
    private String projectname;

    @ApiModelProperty(value = "工程进度")
    @TableField("projectProgress")
    private String projectprogress;

    @ApiModelProperty(value = "工程类别")
    @TableField("projectType")
    private String projecttype;

    @ApiModelProperty(value = "工程级别")
    @TableField("projectLevel")
    private String projectlevel;

    @ApiModelProperty(value = "浇筑方量")
    @TableField("pourSquare")
    private String poursquare;

    @ApiModelProperty(value = "工程地址")
    @TableField("projectAddress")
    private String projectaddress;

    @ApiModelProperty(value = "运输距离")
    @TableField("transportationDistance")
    private Double transportationdistance;

    @ApiModelProperty(value = "建设单位")
    private String construction;

    @ApiModelProperty(value = "施工单位")
    @TableField("constructionUnit")
    private String constructionunit;

    @ApiModelProperty(value = "客户名称")
    @TableField("customerName")
    private String customername;

    @ApiModelProperty(value = "预计开工日期")
    @TableField("startDate")
    private Date startdate;

    @ApiModelProperty(value = "预计开工日期")
    @TableField("state")
    private String state;

}
