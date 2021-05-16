package com.lemon.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lemon.common.Result;
import com.lemon.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("toList")
    @ApiOperation("项目列表")
    public Result toList(Integer userId){
        Result result = null;
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("create_user", userId);
        List list = projectService.list(queryWrapper);
        result = new Result("1", list, "项目列表");
        return result;
    }
}
