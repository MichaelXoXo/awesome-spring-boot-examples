package com.michael.springbootswagger.model;

import com.michael.springbootswagger.constants.UserSexEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Michael
 * @create 2019-07-13 18:33
 */
@Data
@ApiModel(description = "UserEntity 实体类")
public class UserEntity {
    @ApiModelProperty(value = "用户 id",dataType="int")
    private int id;
    @ApiModelProperty(value = "用户名", required = true)
    private String userName;
    @ApiModelProperty(value = "密码" )
    private String passWord;
    @ApiModelProperty(value = "性别")
    private UserSexEnum userSex;
    @ApiModelProperty(value = "昵称" )
    private String nickName;

    public UserEntity(int id, String userName, String passWord) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
    }
}
