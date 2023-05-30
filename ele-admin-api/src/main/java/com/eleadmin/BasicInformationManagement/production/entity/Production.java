package com.eleadmin.BasicInformationManagement.production.entity;

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
 * @since 2023-05-28 17:00:46
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Production对象", description = "")
public class Production implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "节点ID，主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "节点名称")
    @TableField("propertyName")
    private String propertyname;

    @ApiModelProperty(value = "父节点ID，外键关联propertyId")
    @TableField("parentId")
    private Integer parentid;

    @ApiModelProperty(value = "节点属性")
    @TableField("subProperty")
    private String subproperty;

    @ApiModelProperty(value = "状态")
    private String propertystate;

    private Integer tenantId;

}
