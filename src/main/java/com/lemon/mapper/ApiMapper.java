package com.lemon.mapper;

import com.lemon.common.ApiListVo;
import com.lemon.pojo.Api;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lemon.pojo.ApiClassification;
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
public interface ApiMapper extends BaseMapper<Api> {

    //
    @Select("SELECT * FROM api WHERE  api_classification_id=#{apiClassificationId}")
    public List<Api> findApi(Integer apiClassificationId);

    @Select("SELECT t1.*, t2.name classificationName FROM api t1, api_classification t2 WHERE t2.project_id = #{projectId} AND t1.api_classification_id=t2.id")
    public List<ApiListVo> showApiListByProject(Integer projectId);

    @Select("SELECT t1.*, t2.name classificationName FROM api t1, api_classification t2 WHERE t2.id = #{apiClassificationId} AND t1.api_classification_id=t2.id")
    public List<ApiListVo> showApiListClassification(Integer apiClassificationId);
}
