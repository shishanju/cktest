package com.lemon.common;

import lombok.Data;

@Data
public class ApiListVo {
    private String id;
    private String name;
    private String method;
    private String url;
    private String classificationName;
}
