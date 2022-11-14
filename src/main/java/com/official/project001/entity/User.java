package com.official.project001.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "用户信息实体类")
public class User {
    @ApiModelProperty(value = "用户ID")
    private int id;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "权限等级")
    private String power;

    @ApiModelProperty(value = "职位")
    private String occupation;
}
