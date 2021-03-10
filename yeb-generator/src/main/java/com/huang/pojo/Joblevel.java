package com.huang.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("t_joblevel")
@ApiModel(value="Joblevel对象", description="")
public class Joblevel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "职称名称")
    private String name;

    @ApiModelProperty(value = "职称等级")
    @TableField("title_level")
    private String titleLevel;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_date")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "是否启用")
    private Boolean enabled;


}
