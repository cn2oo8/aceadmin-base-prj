package com.shareyi.jshow.controller;

import com.shareyi.jshow.common.CommonResult;
import com.shareyi.jshow.common.PageQuery;
import com.shareyi.jshow.constant.CommonConstant;
import com.shareyi.jshow.domain.BasicDomain;
import com.shareyi.jshow.service.BaseService;
import com.shareyi.jshow.web.base.BaseController;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 抽象的基础controller
 *
 * @author david
 * @date 2018/8/21
 */
public abstract class AbstractController<T extends BasicDomain> extends BaseController {

    /**
     * 基础新增页面
     *
     * @return
     */
    @RequestMapping(value = "manage", method = {RequestMethod.GET, RequestMethod.POST})
    public String manage() {
        return getPath() + "/manage";
    }

    /**
     * 基础新增页面
     *
     * @return
     */
    @RequestMapping(value = "add", method = {RequestMethod.GET, RequestMethod.POST})
    public String add() {
        return getPath() + "/add";
    }


    /**
     * 基础新增服务
     *
     * @param t
     * @return
     */
    @RequestMapping(value = "doAdd", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map doAdd(T t) {
        return getService().add(t).getReturnMap();
    }


    /**
     * 基础新增页面
     *
     * @return
     */
    @RequestMapping(value = "update", method = {RequestMethod.GET, RequestMethod.POST})
    public String update() {
        return getPath() + "/update";
    }

    /**
     * 基础更新服务
     *
     * @param t
     * @return
     */
    @RequestMapping(value = "doUpdate", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map doUpdate(T t) {
        return getService().update(t).getReturnMap();
    }

    /**
     * 基础删除服务
     *
     * @param primaryKey
     * @return
     */
    @RequestMapping(value = "delete", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map delete(Long primaryKey) {
        return getService().deleteByPk(primaryKey).getReturnMap();
    }

    /**
     * 基础主键获取服务
     *
     * @param primaryKey
     * @return
     */
    @RequestMapping(value = "getByPk", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map getByPk(Long primaryKey) {
        return getService().getByPk(primaryKey).getReturnMap();
    }

    /**
     * 基础分页查询服务
     *
     * @param request
     * @param context
     * @return
     */
    @RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST})
    public String queryByPage(HttpServletRequest request, ModelMap context) {
        PageQuery pageQuery = new PageQuery(request, this.getPageSize(request, CommonConstant.DEF_PAGE_SIZE, CommonConstant.MAX_PAGE_SIZE));
        CommonResult result = getService().queryByPage(pageQuery);
        this.toVm(result, context);
        return getPath() + "/list";
    }

    /**
     * 基础服务
     *
     * @return
     */
    public abstract BaseService getService();

    /**
     * 获取路径path
     *
     * @return
     */
    protected abstract String getPath();
}
