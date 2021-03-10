package com.huang.server.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author huang
 * @since 2021-03-03
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false,of = "name")
@Accessors(chain = true)
@TableName("t_department")
@ApiModel(value="Department对象", description="")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "部门名称")
    @Excel(name = "部门")
    @NonNull
    private String name;

    @ApiModelProperty(value = "父Id")
    @TableField("parent_id")
    private Integer parentId;

    @ApiModelProperty(value = "路径")
    @TableField("dep_path")
    private String depPath;

    @ApiModelProperty(value = "是否启用")
    private Boolean enabled;

    @ApiModelProperty(value = "是否上级")
    @TableField("is_parent")
    private Boolean isParent;

    @ApiModelProperty(value = "子部门列表")
    @TableField(exist = false)
    private List<Department> children = new ArrayList<>();

    @ApiModelProperty(value = "返回结果，存储过程使用")
    @TableField(exist = false)
    private Integer result;
}
