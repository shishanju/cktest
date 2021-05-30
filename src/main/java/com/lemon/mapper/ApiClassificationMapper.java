package com.lemon.mapper;

import com.lemon.common.ApiClassificationVo;
import com.lemon.pojo.ApiClassification;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
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
public interface ApiClassificationMapper extends BaseMapper<ApiClassification> {

    @Select("SELECT * FROM api_classification WHERE project_id =#{projectId}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "project_id", property = "projectId"),
            @Result(column = "id", property = "apis", many = @Many(select = "com.lemon.mapper.ApiMapper.findApi"))
    })
    public List<ApiClassificationVo> getWithApi(Integer projectId);


}
