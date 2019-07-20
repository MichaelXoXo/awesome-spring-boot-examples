package com.michael.springbootmybatis.mapper;

import com.github.pagehelper.Page;
import com.michael.springbootmybatis.enums.UserSexEnum;
import com.michael.springbootmybatis.model.UserEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Michael
 * @create 2019-07-20 10:51
 */
public interface UserMapper {
    //    @Results({
//            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
//            @Result(property = "nickName", column = "nick_name")
//    })
    @Select("SELECT * FROM users")
    Page<UserEntity> getAll();

//    @Results({
//            @Result(property = "userSex", column = "user_sex"),
//            @Result(property = "nickName", column = "nick_name")
//    })
    @Select("SELECT * FROM users WHERE id = #{id}")
    UserEntity getUserById(Long id);

    @Insert("INSERT INTO users(userName, passWord, user_sex, nick_name) " +
            "VALUES(#{userName}, #{passWord}, #{userSex}, #{nickName})")
    void insert(UserEntity user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id = #{id}")
    void update(UserEntity user);

    @Delete("DELETE FROM users WHERE id= #{id}")
    void deleteUserById(Long id);
}
