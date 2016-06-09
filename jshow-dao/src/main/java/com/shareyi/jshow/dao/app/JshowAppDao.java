
/**
 * Copyright(c) 2013-  www.shareyi.com
 *
 */
 package com.shareyi.jshow.dao.app;

import java.util.List;
import com.shareyi.jshow.domain.app.JshowApp;
import java.util.Map;
/**
 * @author zhangshibin
 * @since 2015-12-7
 * 应用信息 Dao接口类
 */
public interface JshowAppDao {
    
    
    
    	/**
     * 添加并返回设置id的JshowApp对象
     * 
     * @param jshowApp
     * @return
     */
    public int addJshowApp(JshowApp jshowApp);
    
	/**
     * 更新JshowApp
     * 
     * @param jshowApp
     */
    public void updateJshowApp(JshowApp jshowApp);
    
    
    

    /**
     * 根据主键删除JshowApp
     * 
     * @param id
     */
    public void deleteJshowApp(Integer id);


	/**
     * 根据主键获取JshowApp
     * 
     * @param id
     * @return
     */	
    public JshowApp getJshowAppById(Integer id);
    

    
	

    /**
     * 根据example取得JshowApp列表
     * 
     * @param  jshowApp
     * @return
     */
    public List<JshowApp> getListByExample(JshowApp jshowApp);

    
	/**
     * 分页取得JshowApp列表
     * 
     * @param paramMap
     * @return
     */
    public List<JshowApp> getJshowAppByPage(Map<String,Object> paramMap);
	
	/**
     * 根据查询条件返回数量
     * 
     * @param paramMap
     * @return
     */
    public int count(Map<String,Object> paramMap);

}
