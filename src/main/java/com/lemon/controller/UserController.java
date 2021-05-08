package com.lemon.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lemon.common.Result;
import com.lemon.pojo.User;
import com.lemon.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author kk
 * @since 2021-05-08
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //注册方法
    //@RequestMapping("/register")
    @PostMapping("/register")
    @ApiOperation(value="注册方法",httpMethod="POST")
    public Result register(User user){
        //user.setRegtime(new Date());
        //调用业务层方法，插入到DB,统一处理异常
        userService.save(user);
        Result result = new Result("1","注册成功");
        return result;
    }

    @GetMapping("/find")
    @ApiOperation(value = "账号验重方法", httpMethod = "GET")
    public Result login(String username){
         Result result = null;
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username", username);
        User user = userService.getOne(queryWrapper);
        if (user == null){
            result = new Result("1", "账号不存在");
        }else {
            result = new Result("0", "账号已存在");
        }
        return result;
    }


}
