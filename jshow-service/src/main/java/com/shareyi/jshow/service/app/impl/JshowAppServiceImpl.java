package com.shareyi.jshow.service.app.impl;



import javax.annotation.Resource;
import java.util.List;
import java.util.Date;
import org.springframework.stereotype.Service;
import org.apache.log4j.Logger;
import com.shareyi.jshow.common.PageQuery;
import com.shareyi.jshow.common.CommonResult;
import com.shareyi.jshow.domain.app.JshowApp;
import com.shareyi.jshow.manager.app.JshowAppManager;
import com.shareyi.jshow.service.app.JshowAppService;


/**
 * @author zhangshibin
 * @since 2015-12-7
 *<p>  应用信息service实现</p>
 *
 */
@Service("jshowAppService")
public class JshowAppServiceImpl implements JshowAppService {

	private static final Logger logger = Logger.getLogger(JshowAppServiceImpl.class);
	
	@Resource(name="jshowAppManager")
	private JshowAppManager jshowAppManager;
    
    public CommonResult<JshowApp> addJshowApp(JshowApp jshowApp) {
		CommonResult<JshowApp> result = new CommonResult<JshowApp>();
		try {
			
				jshowApp.setCreated(new Date());

			result.addDefaultModel(jshowAppManager.addJshowApp(jshowApp));
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("添加 应用信息失败", e);
			result.setSuccess(false);
		}
		return result;
	}
	
	public CommonResult<JshowApp> updateJshowApp(JshowApp jshowApp) {
		CommonResult<JshowApp> result = new CommonResult<JshowApp>();
		try {
			
				jshowApp.setModified(new Date());
			 
			jshowAppManager.updateJshowApp(jshowApp);
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("更新 应用信息失败", e);
			result.setSuccess(false);
		}
		return result;
	}
	
   

	public CommonResult<JshowApp> deleteJshowApp(Integer id) {
		CommonResult<JshowApp> result = new CommonResult<JshowApp>();
		try {
			jshowAppManager.deleteJshowApp(id);
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("删除 应用信息失败", e);
			result.setSuccess(false);
		}
		return result;
    }


    	public CommonResult<JshowApp> getJshowAppById(Integer id) {
		CommonResult<JshowApp> result = new CommonResult<JshowApp>();
		try {
			result.addDefaultModel("jshowApp", jshowAppManager.getJshowAppById(id));
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("根据主键获取 应用信息失败", e);
			result.setSuccess(false);
		}
		return result;
	}
	

        

	public CommonResult<List<JshowApp>> getListByExample(JshowApp jshowApp) {
		CommonResult<List<JshowApp>> result = new CommonResult<List<JshowApp>>();
		try {
			List<JshowApp> list = jshowAppManager.getListByExample(jshowApp);
			result.addDefaultModel("list", list);
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("取得 应用信息失败", e);
			result.setSuccess(false);
		}
		return result;
	}

	
	public CommonResult<List<JshowApp>> getJshowAppByPage(PageQuery pageQuery) {
		CommonResult<List<JshowApp>> result = new CommonResult<List<JshowApp>>();
		try {
			int totalCount = this.count(pageQuery);
			if (totalCount > 0) {
				pageQuery.setTotalCount(totalCount);
				List<JshowApp> list = jshowAppManager.getJshowAppByPage(pageQuery);
				result.addDefaultModel("list", list);
				result.addModel("pageQuery", pageQuery);
			}
			result.setSuccess(true);
		} catch (Exception e) {
			logger.error("分页获取 应用信息失败", e);
			result.setSuccess(false);
		}
		return result;
	}
	
	public int count(PageQuery pageQuery) {
		return jshowAppManager.count(pageQuery);
	}


	/******* getter and setter ***/
	public JshowAppManager getJshowAppManager() {
		return jshowAppManager;
	}

	public void setJshowAppManager(JshowAppManager jshowAppManager) {
		this.jshowAppManager = jshowAppManager;
	}

}
