package com.michael.springbootswagger.controller;

import com.michael.springbootswagger.model.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Michael
 * @create 2019-07-13 18:36
 */
@RestController
@RequestMapping("/api/v1/")
@Api(value = "用户模块", tags = {"User"})
public class UserController {

    // 模拟数据库
    public static List<UserEntity> users = new ArrayList<>();

    static {
        UserEntity user1 = new UserEntity(1, "michael", "123");
        UserEntity user2 = new UserEntity(2, "qq", "123");
        UserEntity user3 = new UserEntity(3, "hh", "123");
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    @ApiOperation(value = "获取用户列表", notes = "获取全部用户信息")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserEntity> getUsers() {
        return users;
    }

    @ApiOperation(value = "查询单用户", notes = "根据用户id 查询其信息")
    @ApiImplicitParam(name = "id", value = "用户id", paramType = "query", required = true)
    @GetMapping("/user/{id}")
    public UserEntity getUser(@PathParam("id") int id) {
        UserEntity user = users.get(id);
        return user;
    }

    @ApiOperation(value = "存储用户信息", notes = "存储用户详细信息")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public UserEntity saveUser(@RequestBody UserEntity user) {
        users.add(user);
        return user;
    }

    @ApiOperation(value = "删除用户", notes = "根据用户id删除用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", paramType = "path")
    })
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public int deleteUser(@PathVariable("id") int id) {
        users.remove(id);
        return id;
    }


    @ApiOperation(value = "更新用户信息", notes = "更新用户的个人信息")
    @PutMapping("/user/")
    public UserEntity updateUser(@RequestBody UserEntity user) {
        int id = user.getId();
        UserEntity oldUser = users.get(id);
        users.set(id, user);
        return user;
    }
}
