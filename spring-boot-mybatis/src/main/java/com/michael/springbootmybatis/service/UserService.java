package com.michael.springbootmybatis.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.michael.springbootmybatis.mapper.UserMapper;
import com.michael.springbootmybatis.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author Michael
 * @create 2019-07-20 12:32
 * <p>
 * User 事务层接口
 * 阿里巴巴建议接口不要写 public，保持简洁
 */
public interface UserService {

    /**
     * 查询所有用户
     *
     * @return
     */
    PageInfo<UserEntity> getAll(int pageNum, int pageSize);

    /**
     * 根据用户 ID 查询用户
     *
     * @param id 用户 ID
     * @return
     */
    UserEntity getUserById(Long id);

    /**
     * 新增一个用户
     *
     * @param user
     */
    void insert(UserEntity user);

    /**
     * 更新用户信息，用户 ID 不传，会更新失败
     *
     * @param user
     */
    String update(UserEntity user);

    /**
     * 根据用户 ID 删除用户
     *
     * @param id
     */
    String deleteById(Long id);

}
