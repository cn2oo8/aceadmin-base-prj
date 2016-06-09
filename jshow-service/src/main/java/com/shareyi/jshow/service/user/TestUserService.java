package com.shareyi.jshow.service.user;

import java.util.List;
import com.shareyi.jshow.common.PageQuery;
import com.shareyi.jshow.common.CommonResult;
import com.shareyi.jshow.domain.user.TestUser;

/**
 * @author zhangshibin
 * @since 2016-05-20
 * jshow 测试用户service 接口
 *
 */
public interface TestUserService {
   
    /**
     * 添加并返回设置id的TestUser对象
     * 
     * @param testUser
     * @return
     */
    public CommonResult<TestUser> addTestUser(TestUser testUser);
    
	/**
     * 更新TestUser
     * 
     * @param testUser
     */
    public CommonResult<TestUser> updateTestUser(TestUser testUser);
    

    

	 /**
     * 根据主键删除TestUser
     * 
     * @param id
     */
    public CommonResult<TestUser> deleteTestUser(Integer id);

	/**
     * 根据主键获取TestUser
     * 
     * @param id
     * @return
     */	
    public CommonResult<TestUser> getTestUserById(Integer id);

     


	
    
	/**
     * 根据example取得唯一的TestUser
     * 
     * @param testUser
     * @return
     */
    public CommonResult<TestUser> getUnique(TestUser testUser);
    



    /**
     * 根据example取得TestUser列表
     * 
     * @param  testUser
     * @return
     */
    public CommonResult<List<TestUser>> getListByExample(TestUser testUser);
    

	/**
     * 分页取得TestUser列表
     * 
     * @param pageQuery
     * @return
     */
    public CommonResult<List<TestUser>> getTestUserByPage(PageQuery pageQuery);
	
	/**
     * 根据查询条件返回数量
     * 
     * @param pageQuery
     * @return
     */
    public int count(PageQuery pageQuery);
	
	
}
