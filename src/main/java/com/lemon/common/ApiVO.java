package com.lemon.common;

import com.lemon.pojo.Api;
import com.lemon.pojo.ApiRequestParam;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ApiVO extends Api {

    private String creatUsername;
    private String host;


    private List<ApiRequestParam> requestParams = new ArrayList<>();
    private List<ApiRequestParam> queryParam = new ArrayList<>();
    private List<ApiRequestParam> bodyParams = new ArrayList<>();
    private List<ApiRequestParam> headerParams = new ArrayList<>();
    private List<ApiRequestParam> bodyRawParams = new ArrayList<>();
}
