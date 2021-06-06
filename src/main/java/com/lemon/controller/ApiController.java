package com.lemon.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lemon.common.ApiClassificationVo;
import com.lemon.common.ApiListVo;
import com.lemon.common.ApiVO;
import com.lemon.common.Result;
import com.lemon.pojo.ApiClassification;
import com.lemon.pojo.User;
import com.lemon.service.ApiService;
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
@RequestMapping("/api")
public class ApiController {

    @Autowired
    ApiService apiService;

    @GetMapping("/showApiUnderProject")
    @ApiOperation("查询接口项目内容")
    public Result showApiListByProject(Integer projectId){
        List<ApiListVo> list = apiService.showApiListByProject(projectId);
        Result result = new Result("1", list);
        return result;
    }

    @GetMapping("/showApiUnderApiClassification")
    @ApiOperation("查询接口内容")
    public Result showApiUnderApiClassification(Integer apiClassificationId){
        List<ApiListVo> list = apiService.showApiListClassification(apiClassificationId);
        Result result = new Result("1", list);
        return result;
    }

    @GetMapping("/toApiView")
    @ApiOperation("查询接口内容")
    public Result findApiViewVO(Integer apiId){
        ApiVO api = apiService.findApiViewVO(apiId);
        Result result = new Result("1", api);
        return result;
    }

}
