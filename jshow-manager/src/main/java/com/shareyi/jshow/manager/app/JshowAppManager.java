/**
 * Copyright(c) 2004-2015 www.shareyi.com
 * com.shareyi.jshow.manager.app.JshowAppManager.java
 */
package com.shareyi.jshow.manager.app;

import com.shareyi.jshow.common.PageQuery;
import com.shareyi.jshow.domain.app.JshowApp;

import java.util.List;

/**
 * @author david
 * @date 2015-12-7
 * 应用信息Manager接口类
 */
public interface JshowAppManager {

    /**
     * 添加并返回设置id的JshowApp对象
     *
     * @param jshowApp
     * @return
     */
    public JshowApp addJshowApp(JshowApp jshowApp);

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
     * @param jshowApp
     * @return
     */
    public List<JshowApp> getListByExample(JshowApp jshowApp);

    /**
     * 分页取得JshowApp列表
     *
     * @param pageQuery
     * @return
     */
    public List<JshowApp> getJshowAppByPage(PageQuery pageQuery);

    /**
     * 根据查询条件返回数量
     *
     * @param pageQuery
     * @return
     */
    public int count(PageQuery pageQuery);

}
