package com.shareyi.jshow.service.app;

import com.shareyi.jshow.common.CommonResult;
import com.shareyi.jshow.common.PageQuery;
import com.shareyi.jshow.domain.app.JshowApp;

import java.util.List;

/**
 * jshow 应用信息service 接口
 *
 * @author david
 * @date 2015-12-7
 */
public interface JshowAppService {

    /**
     * 添加并返回设置id的JshowApp对象
     *
     * @param jshowApp
     * @return
     */
    CommonResult<JshowApp> addJshowApp(JshowApp jshowApp);

    /**
     * 更新JshowApp
     *
     * @param jshowApp
     */
    CommonResult<JshowApp> updateJshowApp(JshowApp jshowApp);


    /**
     * 根据主键删除JshowApp
     *
     * @param id
     */
    CommonResult<JshowApp> deleteJshowApp(Integer id);

    /**
     * 根据主键获取JshowApp
     *
     * @param id
     * @return
     */
    CommonResult<JshowApp> getJshowAppById(Integer id);

    /**
     * 分页取得JshowApp列表
     *
     * @param pageQuery
     * @return
     */
    CommonResult<List<JshowApp>> getJshowAppByPage(PageQuery pageQuery);

    /**
     * 根据查询条件返回数量
     *
     * @param pageQuery
     * @return
     */
    int count(PageQuery pageQuery);


}
