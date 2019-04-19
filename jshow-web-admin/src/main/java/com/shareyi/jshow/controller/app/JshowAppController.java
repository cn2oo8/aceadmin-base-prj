/**
 * Copyright(c) 2004-2015 www.shareyi.com
 * com.shareyi.jshow.controller.app.JshowAppController.java
 */
package com.shareyi.jshow.controller.app;

import com.shareyi.jshow.common.CommonResult;
import com.shareyi.jshow.common.PageQuery;
import com.shareyi.jshow.domain.app.JshowApp;
import com.shareyi.jshow.service.app.JshowAppService;
import com.shareyi.jshow.web.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/app/jshowApp")
public class JshowAppController extends BaseController {

    @Resource(name = "jshowAppService")
    private JshowAppService jshowAppService;


    @RequestMapping(value = "manage", method = {RequestMethod.GET, RequestMethod.POST})
    public String manage() {
        return "app/jshowApp/manage";
    }


    @RequestMapping(value = "add", method = {RequestMethod.GET, RequestMethod.POST})
    public String add() {
        return "app/jshowApp/add";
    }


    @RequestMapping(value = "doAdd", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    Map<String, Object> doAdd(JshowApp jshowApp, ModelMap context) {
        CommonResult<JshowApp> result = jshowAppService.addJshowApp(jshowApp);
        return result.getReturnMap();
    }


    @RequestMapping(value = "update", method = {RequestMethod.GET, RequestMethod.POST})
    public String update(JshowApp jshowApp, ModelMap context) {
        CommonResult<JshowApp> result = jshowAppService.getJshowAppById(jshowApp.getId());
        this.toVm(result, context);
        return "app/jshowApp/update";
    }


    @RequestMapping(value = "doUpdate", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    Map<String, Object> doUpdate(JshowApp jshowApp, ModelMap context) {
        CommonResult<JshowApp> result = jshowAppService.updateJshowApp(jshowApp);
        return result.getReturnMap();
    }


    @RequestMapping(value = "view", method = {RequestMethod.GET, RequestMethod.POST})
    public String view(JshowApp jshowApp, ModelMap context) {
        CommonResult<JshowApp> result = jshowAppService.getJshowAppById(jshowApp.getId());
        this.toVm(result, context);
        return "app/jshowApp/view";
    }


    @RequestMapping(value = "doDelete", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    Map<String, Object> doDelete(JshowApp jshowApp) {
        CommonResult<JshowApp> result = jshowAppService.deleteJshowApp(jshowApp.getId());
        return result.getReturnMap();
    }

    @RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(HttpServletRequest request, ModelMap context) {
        int pageSize = this.getPageSize(request, 20, 200);
        PageQuery pageQuery = new PageQuery(request, pageSize);
        CommonResult<List<JshowApp>> result = jshowAppService.getJshowAppByPage(pageQuery);
        this.toVm(result, context);
        return "app/jshowApp/list";
    }


}
