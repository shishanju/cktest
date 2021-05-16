package com.lemon.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

//把当前类对象存入到spring容器中
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 1.每次对数据更新会自动填充时间，次例子新增用户，自动增添新增添加的时间
     * 2.此方法为insert方法
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("regtime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
