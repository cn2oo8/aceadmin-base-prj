package com.shareyi.jshow.manager.app.impl;

import com.shareyi.jshow.common.PageQuery;
import com.shareyi.jshow.dao.app.JshowAppDao;
import com.shareyi.jshow.domain.app.JshowApp;
import com.shareyi.jshow.manager.app.JshowAppManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author david
 * @date 2015-12-7
 * 应用信息Manager实现类
 */
@Component("jshowAppManager")
public class JshowAppManagerImpl implements JshowAppManager {

    @Resource(name = "jshowAppDao")
    private JshowAppDao jshowAppDao;


    public JshowApp addJshowApp(JshowApp jshowApp) {
        int i = jshowAppDao.addJshowApp(jshowApp);
        return jshowApp;
    }

    public void updateJshowApp(JshowApp jshowApp) {
        jshowAppDao.updateJshowApp(jshowApp);
    }


    public void deleteJshowApp(Integer id) {
        jshowAppDao.deleteJshowApp(id);
    }


    public JshowApp getJshowAppById(Integer id) {
        return jshowAppDao.getJshowAppById(id);
    }


    public List<JshowApp> getListByExample(JshowApp jshowApp) {
        return jshowAppDao.getListByExample(jshowApp);
    }


    public List<JshowApp> getJshowAppByPage(PageQuery pageQuery) {
        return jshowAppDao.getJshowAppByPage(pageQuery.getParams());
    }

    public int count(PageQuery pageQuery) {
        return jshowAppDao.count(pageQuery.getParams());
    }

    /******* getter and setter ***/

    public JshowAppDao getJshowAppDao() {
        return jshowAppDao;
    }

    public void setJshowAppDao(JshowAppDao jshowAppDao) {
        this.jshowAppDao = jshowAppDao;
    }
}
