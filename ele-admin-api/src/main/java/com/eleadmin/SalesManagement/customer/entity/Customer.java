package com.eleadmin.SalesManagement.customer.entity;

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
 * @since 2023-04-26 15:35:14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Customer对象", description = "")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "单位名称")
    @TableField("unitName")
    private String unitname;

    @ApiModelProperty(value = "单位类别")
    @TableField("unitType")
    private String unittype;

    @ApiModelProperty(value = "法人代表")
    @TableField("legalRepresentative")
    private String legalrepresentative;

    @ApiModelProperty(value = "联系电话")
    @TableField("unitPhone")
    private String unitphone;

    @ApiModelProperty(value = "传真号")
    @TableField("faxNumber")
    private String faxnumber;

    @ApiModelProperty(value = "电子邮箱")
    @TableField("unitEmail")
    private String unitemail;

    @ApiModelProperty(value = "联系地址")
    @TableField("unitAddress")
    private String unitaddress;

    @ApiModelProperty(value = "邮编")
    private String zipcode;

    @ApiModelProperty(value = "业务员")
    private String salesman;

    @ApiModelProperty(value = "纳税号")
    @TableField("ratepayingNumber")
    private String ratepayingnumber;

    @ApiModelProperty(value = "状态")
    private String state;

    @ApiModelProperty(value = "备注")
    private String remarks;

    private Integer tenantId;

}
