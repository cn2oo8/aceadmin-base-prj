
		
	/**
	 * Copyright(c) 2004-2016 www.shareyi.com
	 */
	
	

 package com.shareyi.jshow.manager.user;

import java.util.List;
import com.shareyi.jshow.common.PageQuery;
import com.shareyi.jshow.domain.user.TestUser;

/**
 * @author zhangshibin
 * @since 2016-05-20
 * 测试用户Manager接口类
 */
public interface TestUserManager {
 
   /**
     * 添加并返回设置id的TestUser对象
     * 
     * @param testUser
     * @return
     */
    public TestUser addTestUser(TestUser testUser);
    
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
     * @param pageQuery
     * @return
     */
    public List<TestUser> getTestUserByPage(PageQuery pageQuery);
	
	/**
     * 根据查询条件返回数量
     * 
     * @param pageQuery
     * @return
     */
    public int count(PageQuery pageQuery);

}
