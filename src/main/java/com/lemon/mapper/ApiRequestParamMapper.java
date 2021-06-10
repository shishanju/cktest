package com.lemon.mapper;

import com.lemon.pojo.ApiRequestParam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kk
 * @since 2021-05-08
 */
public interface ApiRequestParamMapper extends BaseMapper<ApiRequestParam> {

    @Select("select * from api_request_param where api_id =#{apiId}")
    public List<ApiRequestParam> findAll(Integer apiId);
}
