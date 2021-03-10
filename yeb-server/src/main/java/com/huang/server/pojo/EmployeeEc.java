package com.huang.server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author huang
 * @since 2021-03-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_employee_ec")
@ApiModel(value="EmployeeEc对象", description="")
public class EmployeeEc implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "员工编号")
    private Integer eid;

    @ApiModelProperty(value = "奖罚日期")
    @TableField("ec_date")
    private LocalDate ecDate;

    @ApiModelProperty(value = "奖罚原因")
    @TableField("ec_reason")
    private String ecReason;

    @ApiModelProperty(value = "奖罚分")
    @TableField("ec_point")
    private Integer ecPoint;

    @ApiModelProperty(value = "奖罚类别，0：奖，1：罚")
    @TableField("ec_type")
    private Integer ecType;

    @ApiModelProperty(value = "备注")
    private String remark;


}
