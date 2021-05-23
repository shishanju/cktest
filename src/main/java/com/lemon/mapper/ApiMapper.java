package com.lemon.mapper;

import com.lemon.pojo.Api;
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
public interface ApiMapper extends BaseMapper<Api> {

    //
    @Select("SELECT * FROM api WHERE  api_classification_id=#{apiClassificationId}")
    public List<Api> findApi(Integer apiClassificationId);

}
