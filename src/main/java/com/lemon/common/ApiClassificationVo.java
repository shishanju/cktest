package com.lemon.common;

import com.lemon.mapper.ApiClassificationMapper;
import com.lemon.pojo.Api;
import com.lemon.pojo.ApiClassification;
import lombok.Data;

import java.util.List;

@Data
public class ApiClassificationVo extends ApiClassification {
    //关联对象
    List<Api> apis;
}
