package com.eleadmin.SalesManagement.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.sql.Date;
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
 * @since 2023-05-31 15:47:21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Order对象", description = "")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("orderNumber")
    private String ordernumber;

    @TableField("orderDate")
    private Date orderdate;

    private String status;

    @TableField("salesContractId")
    private Integer salescontractid;


    @TableField("pouringDate")
    private Date pouringdate;

    @TableField("concreteMarkings")
    private String concretemarkings;

    @TableField("pouringMethod")
    private String pouringmethod;

    @TableField("plannedSqueraVolume")
    private int plannedsqueravolume;

    private String salesman;

    private String remarks;

    @ApiModelProperty(value = "强度等级")
    @TableField("Strengthlevel")
    private String strengthlevel;

    @ApiModelProperty(value = "坍落度")
    @TableField("Slump")
    private String slump;

    @ApiModelProperty(value = "抗渗等级")
    @TableField("Impermeabilitylevel")
    private String impermeabilitylevel;

    @ApiModelProperty(value = "抗冻等级")
    @TableField("FrostResistancelevel")
    private String frostresistancelevel;

    @ApiModelProperty(value = "抗硫酸盐等级")
    @TableField("SulfateResistancelevel")
    private String sulfateresistancelevel;

    @ApiModelProperty(value = "抗氯离子等级")
    @TableField("Chlorideionresistancelevel")
    private String chlorideionresistancelevel;

    @ApiModelProperty(value = "外加剂")
    @TableField("Admixture")
    private String admixture;

    @ApiModelProperty(value = "特殊原材料")
    @TableField("Specialrawmaterials")
    private String specialrawmaterials;

}
