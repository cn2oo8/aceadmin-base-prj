package com.shareyi.jshow.service.user.impl;



import javax.annotation.Resource;
import java.util.List;
import java.util.Date;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import com.shareyi.jshow.common.PageQuery;
import com.shareyi.jshow.common.CommonResult;
import com.shareyi.jshow.domain.user.TestUser;
import com.shareyi.jshow.manager.user.TestUserManager;
import com.shareyi.jshow.service.user.TestUserService;


/**
 * @author zhangshibin
 * @since 2016-05-20
 *<p>  测试用户service实现</p>
 *
 */
@Service("testUserService")
public class TestUserServiceImpl implements TestUserService {

	private static final Logger logger = Logger.getLogger(TestUserServiceImpl.class);
	
	@Resource(name="testUserManager")
	private TestUserManager testUserManager;
    
    public CommonResult<TestUser> addTestUser(TestUser testUser) {
		CommonResult<TestUser> result = new CommonResult<TestUser>();
		try {
			
				testUser.setCreated(new Date());
			 
			result.addDefaultModel(testUserManager.addTestUser(testUser));
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("添加 测试用户失败", e);
			result.setSuccess(false);
		}
		return result;
	}
	
	public CommonResult<TestUser> updateTestUser(TestUser testUser) {
		CommonResult<TestUser> result = new CommonResult<TestUser>();
		try {
			
				testUser.setModified(new Date());
			 
			testUserManager.updateTestUser(testUser);
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("更新 测试用户失败", e);
			result.setSuccess(false);
		}
		return result;
	}
	
   

	public CommonResult<TestUser> deleteTestUser(Integer id) {
		CommonResult<TestUser> result = new CommonResult<TestUser>();
		try {
			testUserManager.deleteTestUser(id);
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("删除 测试用户失败", e);
			result.setSuccess(false);
		}
		return result;
    }


    	public CommonResult<TestUser> getTestUserById(Integer id) {
		CommonResult<TestUser> result = new CommonResult<TestUser>();
		try {
			result.addDefaultModel("testUser", testUserManager.getTestUserById(id));
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("根据主键获取 测试用户失败", e);
			result.setSuccess(false);
		}
		return result;
	}
	

        
	


	public CommonResult<TestUser> getUnique(TestUser testUser) {
		CommonResult<TestUser> result = new CommonResult<TestUser>();
		try {
			result.addDefaultModel(testUserManager.getUnique(testUser));
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("根据example获取唯一 测试用户失败", e);
			result.setSuccess(false);
		}
		return result;
	}


	public CommonResult<List<TestUser>> getListByExample(TestUser testUser) {
		CommonResult<List<TestUser>> result = new CommonResult<List<TestUser>>();
		try {
			List<TestUser> list = testUserManager.getListByExample(testUser);
			result.addDefaultModel("list", list);
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("取得 测试用户失败", e);
			result.setSuccess(false);
		}
		return result;
	}

	
	public CommonResult<List<TestUser>> getTestUserByPage(PageQuery pageQuery) {
		CommonResult<List<TestUser>> result = new CommonResult<List<TestUser>>();
		try {
			int totalCount = this.count(pageQuery);
			if (totalCount > 0) {
				pageQuery.setTotalCount(totalCount);
				List<TestUser> list = testUserManager.getTestUserByPage(pageQuery);
				result.addDefaultModel("list", list);
				result.addModel("pageQuery", pageQuery);
			}
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("分页获取 测试用户失败", e);
			result.setSuccess(false);
		}
		return result;
	}
	
	public int count(PageQuery pageQuery) {
		return testUserManager.count(pageQuery);
	}


	/******* getter and setter ***/
	public TestUserManager getTestUserManager() {
		return testUserManager;
	}

	public void setTestUserManager(TestUserManager testUserManager) {
		this.testUserManager = testUserManager;
	}

}
