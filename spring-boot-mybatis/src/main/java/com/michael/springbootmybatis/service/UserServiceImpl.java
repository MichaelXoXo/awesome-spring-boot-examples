package com.michael.springbootmybatis.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.michael.springbootmybatis.mapper.UserMapper;
import com.michael.springbootmybatis.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User 事务实现类
 *
 * @author Michael
 * @create 2019-07-20 12:42
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<UserEntity> getAll(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<UserEntity> pageInfo = new PageInfo<>(userMapper.getAll());
//        Long total = pageInfo.getTotal();
//        List<UserEntity> users = pageInfo.getList();
//        Map<String,Object> map = new HashMap<>();
//        map.put("total", total);
//        map.put("data", users);
        return pageInfo;
    }

    @Override
    public UserEntity getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void insert(UserEntity user) {
        userMapper.insert(user);
    }

    @Override
    public String update(UserEntity user) {
        userMapper.update(user);
        return "success";
    }

    @Override
    public String deleteById(Long id) {
        userMapper.deleteUserById(id);
        return "success";
    }

}
