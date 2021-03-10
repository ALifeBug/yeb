package com.huang.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@TableName("t_salary")
@ApiModel(value="Salary对象", description="")
public class Salary implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "基本工资")
    @TableField("basic_salary")
    private Integer basicSalary;

    @ApiModelProperty(value = "奖金")
    private Integer bonus;

    @ApiModelProperty(value = "午餐补助")
    @TableField("lunch_salary")
    private Integer lunchSalary;

    @ApiModelProperty(value = "交通补助")
    @TableField("traffic_salary")
    private Integer trafficSalary;

    @ApiModelProperty(value = "应发工资")
    @TableField("all_salary")
    private Integer allSalary;

    @ApiModelProperty(value = "养老金基数")
    @TableField("pension_base")
    private Integer pensionBase;

    @ApiModelProperty(value = "养老金比率")
    @TableField("pension_per")
    private Float pensionPer;

    @ApiModelProperty(value = "启用时间")
    @TableField("create_date")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private LocalDate createDate;

    @ApiModelProperty(value = "医疗基数")
    @TableField("medical_base")
    private Integer medicalBase;

    @ApiModelProperty(value = "医疗保险比率")
    @TableField("medical_per")
    private Float medicalPer;

    @ApiModelProperty(value = "公积金基数")
    @TableField("accumulation_fund_base")
    private Integer accumulationFundBase;

    @ApiModelProperty(value = "公积金比率")
    @TableField("accumulation_fund_per")
    private Float accumulationFundPer;

    @ApiModelProperty(value = "名称")
    private String name;


}
