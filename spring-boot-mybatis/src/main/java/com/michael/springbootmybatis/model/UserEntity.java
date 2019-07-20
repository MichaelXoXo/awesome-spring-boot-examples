package com.michael.springbootmybatis.model;

import com.michael.springbootmybatis.enums.UserSexEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Michael
 * @create 2019-07-20 10:53
 */
@Data
@ApiModel(description = "UserEntity 实体类")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "用户 id", dataType = "Long")
    private Long id;
    @ApiModelProperty(value = "用户名", required = true)
    private String userName;
    @ApiModelProperty(value = "密码")
    private String passWord;
    @ApiModelProperty(value = "性别")
    private UserSexEnum userSex;
    @ApiModelProperty(value = "昵称")
    private String nickName;


    @Override
    public String toString() {
        return "userName " + this.userName + ", password " + this.passWord + " , sex " + this.userSex;
    }

}

