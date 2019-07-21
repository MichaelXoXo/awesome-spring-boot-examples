package com.michael.springbootmybatis.mapper;

import com.michael.springbootmybatis.enums.UserSexEnum;
import com.michael.springbootmybatis.model.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author Michael
 * @create 2019-07-20 10:51
 */
public interface UserMapper {

    @Select("SELECT * FROM users")
    @Results(id = "user", value = {
            @Result(property = "userSex", column = "user_sex"),
            @Result(property = "nickName", column = "nick_name")
    })
    List<UserEntity> getAll();

    @ResultMap("user")
    @Select({
            "<script>",
            "SELECT * ",
            "FROM users WHERE id IN",
            "<foreach item='id' index='index' collection='IDs' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    List<UserEntity> getUserById(@Param("IDs") List<String> ids);

    @Insert("INSERT INTO users(userName, passWord, user_sex, nick_name) " +
            "VALUES(#{userName}, #{passWord}, #{userSex}, #{nickName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
//    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    void insert(UserEntity user);

    @Update("UPDATE users SET userName=#{userName},nick_name=#{nickName} WHERE id = #{id}")
    void update(UserEntity user);

    @Delete("DELETE FROM users WHERE id= #{id}")
    void deleteUserById(Long id);
}
