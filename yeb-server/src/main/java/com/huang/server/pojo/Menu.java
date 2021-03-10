package com.huang.server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_menu")
@ApiModel(value="Menu对象", description="")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "url")
    private String url;

    @ApiModelProperty(value = "path")
    private String path;

    @ApiModelProperty(value = "组件")
    private String component;

    @ApiModelProperty(value = "菜单名")
    private String name;

    @ApiModelProperty(value = "图标")
    @TableField("icon_cls")
    private String iconCls;

    @ApiModelProperty(value = "是否保持激活")
    @TableField("keep_alive")
    private Boolean keepAlive;

    @ApiModelProperty(value = "是否要求权限")
    @TableField("require_auth")
    private Boolean requireAuth;

    @ApiModelProperty(value = "父id")
    @TableField("parent_id")
    private Integer parentId;

    @ApiModelProperty(value = "是否启用")
    private Boolean enabled;

    @ApiModelProperty(value = "子菜单")
    @TableField(exist = false) //添加注解，否则查询报错，因为表里没有这个字段
    private List<Menu> children;

    @ApiModelProperty(value = "角色列表")
    @TableField(exist = false)
    private List<Role> roles;
}
