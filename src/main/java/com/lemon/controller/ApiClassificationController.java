package com.lemon.controller;


import com.lemon.common.ApiClassificationVo;
import com.lemon.common.Result;
import com.lemon.pojo.ApiClassification;
import com.lemon.pojo.Project;
import com.lemon.pojo.User;
import com.lemon.service.ApiClassificationService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/apiClassification")
public class ApiClassificationController {

    @Autowired
    ApiClassificationService apiClassificationService;

    @GetMapping("/toIndex")
    public Result getWithApi(Integer projectId, Integer tab){
        Result result = null;
        if (tab ==  1){
            //进入接口列表
            List<ApiClassificationVo> list = apiClassificationService.getWithApi(projectId);
            result = new Result("1", list, "查询分类同时也加载延迟时间");
        }else {
            //进入测试列表
        }
        return result;
    }

    @DeleteMapping("/{projectId}")
    @ApiOperation("删除接口")
    public Result deleteByIdList(@PathVariable("projectId") Integer projectId, ApiClassification apiClassification){
        Result result = null;
        apiClassification.setId(projectId);
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        apiClassification.setCreateUser(user.getId());
        apiClassificationService.removeById(apiClassification);
        result = new Result("1", apiClassification,"删除成功");
        return result;
    }
}
