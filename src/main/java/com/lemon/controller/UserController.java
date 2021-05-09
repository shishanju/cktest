package com.lemon.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lemon.common.Result;
import com.lemon.pojo.User;
import com.lemon.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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
        user.setRegtime(new Date());
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

    //登录方法
    @PostMapping("/login")
    @ApiOperation(value="登录方法",httpMethod="POST")
    public Result login(User user){
        Result result = null;
        try {
            //获取到username和password的token
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            //shiro
            Subject subject =  SecurityUtils.getSubject();
            subject.login(token);
        } catch (AuthenticationException e) {
            if (e instanceof UnknownAccountException e1){
                result = new Result("0","用户名错误");
            }else {
                result = new Result("0","密码错误");
            }
            e.printStackTrace();
        }
        //调用业务层方法，插入到DB,统一处理异常
        return result;
    }

}
