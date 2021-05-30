package com.lemon.service.impl;

import com.lemon.common.ApiListVo;
import com.lemon.pojo.Api;
import com.lemon.mapper.ApiMapper;
import com.lemon.pojo.ApiClassification;
import com.lemon.service.ApiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kk
 * @since 2021-05-08
 */
@Service
public class ApiServiceImpl extends ServiceImpl<ApiMapper, Api> implements ApiService {

    @Autowired
    ApiMapper apiMapper;

    public List<ApiListVo> showApiListByProject(Integer projectId){
        return apiMapper.showApiListByProject(projectId);
    }

    public List<ApiListVo> showApiListClassification(Integer apiClassificationId){
        return apiMapper.showApiListClassification(apiClassificationId);
    }

}
