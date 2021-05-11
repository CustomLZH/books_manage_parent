package com.guaiwuxue.dao;

import com.github.pagehelper.Page;
import com.guaiwuxue.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: liuzhaohong
 * @Date: 2021/4/3 17:23
 * @Version: 1.0
 */
public interface UsersDao {

    /**
     * 查询全部用户部分信息
     * @return
     */
    List<Users> findAllToBorrowInfoCreate();

    /**
     * 分页查询
     * @param requirement
     * @return
     */
    Page<Users> findPageByCondition(@Param("requirement") String requirement);

    /**
     * 根据id删除用户
     * @param userId
     */
    void delete(Long userId);

    /**
     * 添加用户
     * @param users
     */
    void createUsers(Users users);

    /**
     * 更新用户
     * @param users
     */
    void updateUsers(Users users);

    /**
     * 根据用户集合删除
     * @param multipleSelection
     */
    void deleteAll(@Param("multipleSelection") List<Users> multipleSelection);
}
