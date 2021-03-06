/**
 * Copyright(c) 2004-2016 www.shareyi.com
 */


package com.shareyi.jshow.dao.user;

import com.shareyi.jshow.domain.user.TestUser;

import java.util.List;
import java.util.Map;

/**
 * @author david
 * @date 2016-05-20
 * 测试用户 Dao接口类
 */
public interface TestUserDao {


    /**
     * 添加并返回设置id的TestUser对象
     *
     * @param testUser
     * @return
     */
    public int addTestUser(TestUser testUser);

    /**
     * 更新TestUser
     *
     * @param testUser
     */
    public void updateTestUser(TestUser testUser);


    /**
     * 根据主键删除TestUser
     *
     * @param id
     */
    public void deleteTestUser(Integer id);


    /**
     * 根据主键获取TestUser
     *
     * @param id
     * @return
     */
    public TestUser getTestUserById(Integer id);


    /**
     * 根据example取得唯一的TestUser
     *
     * @param testUser
     * @return
     */
    public TestUser getUnique(TestUser testUser);


    /**
     * 根据example取得TestUser列表
     *
     * @param  testUser
     * @return
     */
    public List<TestUser> getListByExample(TestUser testUser);


    /**
     * 分页取得TestUser列表
     *
     * @param paramMap
     * @return
     */
    public List<TestUser> getTestUserByPage(Map<String, Object> paramMap);

    /**
     * 根据查询条件返回数量
     *
     * @param paramMap
     * @return
     */
    public int count(Map<String, Object> paramMap);

}
