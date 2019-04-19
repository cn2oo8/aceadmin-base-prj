package com.shareyi.jshow.manager.user.impl;

import com.shareyi.jshow.common.PageQuery;
import com.shareyi.jshow.dao.user.TestUserDao;
import com.shareyi.jshow.domain.user.TestUser;
import com.shareyi.jshow.manager.user.TestUserManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author david
 * @date 2016-05-20
 * 测试用户Manager实现类
 */
@Component("testUserManager")
public class TestUserManagerImpl implements TestUserManager {

    @Resource(name = "testUserDao")
    private TestUserDao testUserDao;


    public TestUser addTestUser(TestUser testUser) {
        int i = testUserDao.addTestUser(testUser);
        return testUser;
    }

    public void updateTestUser(TestUser testUser) {
        testUserDao.updateTestUser(testUser);
    }


    public void deleteTestUser(Integer id) {
        testUserDao.deleteTestUser(id);
    }


    public TestUser getTestUserById(Integer id) {
        return testUserDao.getTestUserById(id);
    }


    public TestUser getUnique(TestUser testUser) {
        return testUserDao.getUnique(testUser);
    }


    public List<TestUser> getListByExample(TestUser testUser) {
        return testUserDao.getListByExample(testUser);
    }


    public List<TestUser> getTestUserByPage(PageQuery pageQuery) {
        return testUserDao.getTestUserByPage(pageQuery.getParams());
    }

    public int count(PageQuery pageQuery) {
        return testUserDao.count(pageQuery.getParams());
    }

    /******* getter and setter ***/

    public TestUserDao getTestUserDao() {
        return testUserDao;
    }

    public void setTestUserDao(TestUserDao testUserDao) {
        this.testUserDao = testUserDao;
    }
}
