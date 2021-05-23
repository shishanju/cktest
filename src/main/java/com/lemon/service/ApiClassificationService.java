package com.lemon.service;

import com.lemon.common.ApiClassificationVo;
import com.lemon.pojo.ApiClassification;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kk
 * @since 2021-05-08
 */
public interface ApiClassificationService extends IService<ApiClassification> {
    public List<ApiClassificationVo> getWithApi(Integer projectId);
}
