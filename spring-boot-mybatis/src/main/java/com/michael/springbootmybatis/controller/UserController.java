package com.michael.springbootmybatis.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.michael.springbootmybatis.model.UserEntity;
import com.michael.springbootmybatis.service.UserService;
import com.michael.springbootmybatis.util.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Michael
 * @create 2019-07-20 10:52
 */
@RestController
@RequestMapping("/api/v1/")
@Api(tags = {"用户相关接口"}, value = "用户模块")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询全部用户
     *
     * @return
     */
    @ApiOperation(value = "获取用户列表", notes = "获取全部用户信息")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Object getUsers(
            @RequestParam(name = "pageNum", defaultValue = "1", required = false) int pageNum,
            @RequestParam(name = "pageSize", defaultValue = "2", required = false) int pageSize) {
        return userService.getAll(pageNum, pageSize);
    }


    /**
     * 根据用户 ID 查询用户
     *
     * @return
     */
    @ApiOperation(value = "查询指定 ID 的用户", notes = "根据用户 id 列表查询其信息")
    @ApiImplicitParam(name = "ids", value = "用户 id 列表", paramType = "path", required = true)
    @GetMapping(value = "/user/{ids}")
    public PageResult getUser(@RequestParam(name = "pageNum", defaultValue = "1", required = false) int pageNum,
                              @RequestParam(name = "pageSize", defaultValue = "2", required = false) int pageSize,
                              @PathVariable String ids) {
        List<String> idLst = Arrays.asList(ids.split(","));
        PageResult user = userService.getUserById(pageNum, pageSize, idLst);
        return user;
    }

    /**
     * 存储用户信息
     *
     * @param user
     */
    @ApiOperation(value = "存储用户信息", notes = "存储用户详细信息")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String save(UserEntity user) {
        userService.insert(user);
        return "Create success, user id: " + user.getId();
    }

    /**
     * 更新用户信息
     *
     * @param user
     */
    @ApiOperation(value = "更新用户信息", notes = "更新用户的个人信息")
    @PutMapping("/user/")
    public void update(@RequestBody UserEntity user) {
        userService.update(user);
    }

    /**
     * 根据用户 ID 删除用户
     *
     * @param id
     */
    @ApiOperation(value = "删除用户", notes = "根据用户id删除用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, paramType = "path")
    })
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }
}
