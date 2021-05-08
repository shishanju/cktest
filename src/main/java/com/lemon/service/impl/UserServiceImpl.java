package com.lemon.service.impl;

import com.lemon.pojo.User;
import com.lemon.mapper.UserMapper;
import com.lemon.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 * implements声明自己使用一个或者多个接口，可以继承多个接口如：implements C,D,E
 * @author kk
 * @since 2021-05-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
