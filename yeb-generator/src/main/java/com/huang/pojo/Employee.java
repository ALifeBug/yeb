package com.huang.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author huang
 * @since 2021-03-04
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
    private String name;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "出生日期")
    private LocalDate birthday;

    @ApiModelProperty(value = "身份证号")
    @TableField("id_card")
    private String idCard;

    @ApiModelProperty(value = "婚姻状况")
    private String wedlock;

    @ApiModelProperty(value = "民族")
    @TableField("nation_id")
    private Integer nationId;

    @ApiModelProperty(value = "籍贯")
    @TableField("native_place")
    private String nativePlace;

    @ApiModelProperty(value = "政治面貌")
    @TableField("politic_id")
    private Integer politicId;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "联系地址")
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
    private String engageForm;

    @ApiModelProperty(value = "最高学历")
    @TableField("tiptop_degree")
    private String tiptopDegree;

    @ApiModelProperty(value = "所属专业")
    private String specialty;

    @ApiModelProperty(value = "毕业院校")
    private String school;

    @ApiModelProperty(value = "入职日期")
    @TableField("begin_date")
    private LocalDate beginDate;

    @ApiModelProperty(value = "在职状态")
    @TableField("work_state")
    private String workState;

    @ApiModelProperty(value = "工号")
    @TableField("work_id")
    private String workId;

    @ApiModelProperty(value = "合同期限")
    @TableField("contract_term")
    private Double contractTerm;

    @ApiModelProperty(value = "转正日期")
    @TableField("conversion_time")
    private LocalDate conversionTime;

    @ApiModelProperty(value = "离职日期")
    @TableField("not_work_date")
    private LocalDate notWorkDate;

    @ApiModelProperty(value = "合同起始日期")
    @TableField("begin_contract")
    private LocalDate beginContract;

    @ApiModelProperty(value = "合同终止日期")
    @TableField("end_contract")
    private LocalDate endContract;

    @ApiModelProperty(value = "工龄")
    @TableField("work_age")
    private Integer workAge;

    @ApiModelProperty(value = "工资账套ID")
    @TableField("salary_id")
    private Integer salaryId;


}
