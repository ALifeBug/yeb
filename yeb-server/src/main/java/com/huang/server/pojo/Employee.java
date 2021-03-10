package com.huang.server.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
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
@TableName("t_employee")
@ApiModel(value="Employee对象", description="")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "员工编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "员工姓名")
    @Excel(name = "员工姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    @Excel(name = "性别")
    private String gender;

    @ApiModelProperty(value = "出生日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @Excel(name = "出生日期",width = 20,format = "yyyy-MM-dd")
    private LocalDate birthday;

    @ApiModelProperty(value = "身份证号")
    @TableField("id_card")
    @Excel(name = "身份证号",width = 30)
    private String idCard;

    @ApiModelProperty(value = "婚姻状况")
    @Excel(name = "婚姻状况")
    private String wedlock;

    @ApiModelProperty(value = "民族")
    @TableField("nation_id")
    private Integer nationId;

    @ApiModelProperty(value = "籍贯")
    @TableField("native_place")
    @Excel(name = "籍贯")
    private String nativePlace;

    @ApiModelProperty(value = "政治面貌")
    @TableField("politic_id")
    private Integer politicId;

    @ApiModelProperty(value = "邮箱")
    @Excel(name = "邮箱",width = 30)
    private String email;

    @ApiModelProperty(value = "电话号码")
    @Excel(name = "电话号码",width = 15)
    private String phone;

    @ApiModelProperty(value = "联系地址")
    @Excel(name = "联系地址",width = 40)
    private String address;

    @ApiModelProperty(value = "所属部门")
    @TableField("department_id")
    private Integer departmentId;

    @ApiModelProperty(value = "职称ID")
    @TableField("job_level_id")
    private Integer jobLevelId;

    @ApiModelProperty(value = "职位ID")
    @TableField("pos_id")
    private Integer posId;

    @ApiModelProperty(value = "聘用形式")
    @TableField("engage_form")
    @Excel(name = "聘用形式")
    private String engageForm;

    @ApiModelProperty(value = "最高学历")
    @TableField("tiptop_degree")
    @Excel(name = "最高学历",width = 20)
    private String tiptopDegree;

    @ApiModelProperty(value = "所属专业")
    @Excel(name = "所属专业",width = 20)
    private String specialty;

    @ApiModelProperty(value = "毕业院校")
    @Excel(name = "毕业院校",width = 20)
    private String school;

    @ApiModelProperty(value = "入职日期")
    @TableField("begin_date")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")//用于返回前端的格式化
    @Excel(name = "入职日期",width = 20,format = "yyyy-MM-dd")
    private LocalDate beginDate;

    @ApiModelProperty(value = "在职状态")
    @TableField("work_state")
    @Excel(name = "在职状态")
    private String workState;

    @ApiModelProperty(value = "工号")
    @TableField("work_id")
    @Excel(name = "工号")
    private String workId;

    @ApiModelProperty(value = "合同期限")
    @TableField("contract_term")
    @Excel(name = "合同期限",suffix = "年")
    private Double contractTerm;

    @ApiModelProperty(value = "转正日期")
    @TableField("conversion_time")
    @Excel(name = "转正日期",width = 20,format = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private LocalDate conversionTime;

    @ApiModelProperty(value = "离职日期")
    @TableField("not_work_date")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private LocalDate notWorkDate;

    @ApiModelProperty(value = "合同起始日期")
    @TableField("begin_contract")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @Excel(name = "合同起始日期",width = 20,format = "yyyy-MM-dd")
    private LocalDate beginContract;

    @ApiModelProperty(value = "合同终止日期")
    @TableField("end_contract")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    @Excel(name = "合同终止日期",width = 20,format = "yyyy-MM-dd")
    private LocalDate endContract;

    @ApiModelProperty(value = "工龄")
    @TableField("work_age")
    private Integer workAge;

    @ApiModelProperty(value = "工资账套ID")
    @TableField("salary_id")
    private Integer salaryId;

    @ApiModelProperty(value = "民族")
    @TableField(exist = false)
    @ExcelEntity(name = "民族")
    private Nation nation;

    @ApiModelProperty(value = "政治面貌")
    @TableField(exist = false)
    @ExcelEntity(name = "政治面貌")
    private PoliticsStatus politicsStatus;

    @ApiModelProperty(value = "部门")
    @TableField(exist = false)
    @ExcelEntity(name = "部门")
    private Department department;

    @ApiModelProperty(value = "职称名称")
    @TableField(exist = false)
    @ExcelEntity(name = "职称")
    private Joblevel joblevel;

    @ApiModelProperty(value = "职位")
    @TableField(exist = false)
    @ExcelEntity(name = "职位")
    private Position position;

    @ApiModelProperty(value = "工资账套")
    @TableField(exist = false)
    private Salary salary;

}
