package com.lemon.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lemon.common.Result;
import com.lemon.pojo.Project;
import com.lemon.pojo.User;
import com.lemon.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kk
 * @since 2021-05-08
 */
@RestController
@RequestMapping("/project")
@Api("项目模块")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/toList")
    @ApiOperation("项目列表")
    public Result toList(Integer userId){
        Result result = null;
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("create_user", userId);
        List list = projectService.list(queryWrapper);
        result = new Result("1", list, "项目列表");
        return result;
    }

    @PostMapping("/add")
    @ApiOperation("添加项目")
    public Result add(Project project){
        Result result = null;
        project.setCreateTime(new Date());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        project.setCreateUser(user.getId());
        projectService.save(project);
        result = new Result("1", "项目添加成功");
        return result;
    }

    @GetMapping("/{projectId}")
    @ApiOperation("查询列表")
    public Result getById(@PathVariable("projectId") Integer projectId){
        Result result = null;
        Project project = projectService.getById(projectId);
        result = new Result("1", project,"查询项目");
        return result;
    }

    @PutMapping("/{projectId}")
    @ApiOperation("更新列表")
    public Result updateById(@PathVariable("projectId") Integer projectId, Project project){
        Result result = null;
        project.setId(projectId);
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        project.setCreateUser(user.getId());
        projectService.updateById(project);
        result = new Result("1", project,"更新项目");
        return result;
    }

    @DeleteMapping("/{projectId}")
    @ApiOperation("删除列表")
    public Result deleteById(@PathVariable("projectId") Integer projectId, Project project){
        Result result = null;
        project.setId(projectId);
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        project.setCreateUser(user.getId());
        projectService.removeById(project);
        result = new Result("1", project,"删除成功");
        return result;
    }
}
