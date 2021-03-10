package com.huang.server.controller;


import com.huang.server.pojo.Joblevel;
import com.huang.server.pojo.RespBean;
import com.huang.server.service.IJoblevelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author huang
 * @since 2021-03-03
 */
@RestController
@RequestMapping("/system/basic/joblevel")
public class JoblevelController {

    @Autowired
    private IJoblevelService joblevelService;

    @ApiOperation(value = "获取所有职称")
    @GetMapping("/")
    public List<Joblevel> getAllJobLevels(){
        return joblevelService.list();
    }

    @ApiOperation(value = "添加职称")
    @PostMapping("/")
    public RespBean addJobLevel(@RequestBody Joblevel joblevel){
        joblevel.setCreateDate(LocalDateTime.now());
        if(joblevelService.save(joblevel)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @ApiOperation(value = "更新职称")
    @PutMapping("/")
    public RespBean getAllJobLevels(@RequestBody Joblevel joblevel){
        if(joblevelService.updateById(joblevel)){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @ApiOperation(value = "删除职称")
    @DeleteMapping("/{id}")
    public RespBean deletePosition(@PathVariable Integer id){
        if(joblevelService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @ApiOperation(value = "批量删除职称")
    @DeleteMapping("/")
    public RespBean deletePositionsByIds(Integer[] ids){
        if(joblevelService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
