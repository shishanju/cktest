package com.lemon.service.impl;

import com.lemon.common.ApiClassificationVo;
import com.lemon.mapper.ApiClassificationMapper;
import com.lemon.pojo.ApiClassification;
import com.lemon.service.ApiClassificationService;
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
public class ApiClassificationServiceImpl extends ServiceImpl<ApiClassificationMapper, ApiClassification> implements ApiClassificationService {

    @Autowired
    ApiClassificationMapper apiClassificationMapper;

    @Override
    public List<ApiClassificationVo> getWithApi(Integer projectId) {
        return apiClassificationMapper.getWithApi(projectId);
    }
}
