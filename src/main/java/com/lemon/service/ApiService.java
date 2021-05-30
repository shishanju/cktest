package com.lemon.service;

import com.lemon.common.ApiListVo;
import com.lemon.pojo.Api;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lemon.pojo.ApiClassification;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kk
 * @since 2021-05-08
 */
public interface ApiService extends IService<Api> {

    public List<ApiListVo> showApiListByProject(Integer projectId);

    public List<ApiListVo> showApiListClassification(Integer apiClassificationId);

}
