/**
 * Copyright(c) 2004-2016 www.shareyi.com
 */


package com.shareyi.jshow.controller.user;

import com.shareyi.jshow.common.CommonResult;
import com.shareyi.jshow.common.PageQuery;
import com.shareyi.jshow.domain.user.TestUser;
import com.shareyi.jshow.service.user.TestUserService;
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

//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user/testUser")
public class TestUserController extends BaseController {

//	private final static Log log = LogFactory.getLog(TestUserAction.class);

    @Resource(name = "testUserService")
    private TestUserService testUserService;


    @RequestMapping(value = "manage", method = {RequestMethod.GET, RequestMethod.POST})
    public String manage() {
        return "user/testUser/manage";
    }


    @RequestMapping(value = "add", method = {RequestMethod.GET, RequestMethod.POST})
    public String add() {
        return "user/testUser/add";
    }


    @RequestMapping(value = "doAdd", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    Map<String, Object> doAdd(TestUser testUser, ModelMap context) {
        CommonResult<TestUser> result = testUserService.addTestUser(testUser);
        return result.getReturnMap();
    }


    @RequestMapping(value = "update", method = {RequestMethod.GET, RequestMethod.POST})
    public String update(TestUser testUser, ModelMap context) {
        CommonResult<TestUser> result = testUserService.getTestUserById(testUser.getId());
        this.toVm(result, context);
        return "user/testUser/update";
    }


    @RequestMapping(value = "doUpdate", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    Map<String, Object> doUpdate(TestUser testUser, ModelMap context) {
        CommonResult<TestUser> result = testUserService.updateTestUser(testUser);
        return result.getReturnMap();
    }


    @RequestMapping(value = "view", method = {RequestMethod.GET, RequestMethod.POST})
    public String view(TestUser testUser, ModelMap context) {
        CommonResult<TestUser> result = testUserService.getTestUserById(testUser.getId());
        this.toVm(result, context);
        return "user/testUser/view";
    }


    @RequestMapping(value = "doDelete", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    Map<String, Object> doDelete(TestUser testUser) {
        CommonResult<TestUser> result = testUserService.deleteTestUser(testUser.getId());
        return result.getReturnMap();
    }

    @RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(HttpServletRequest request, ModelMap context) {
        int pageSize = this.getPageSize(request, 20, 200);
        PageQuery pageQuery = new PageQuery(request, pageSize);
        CommonResult<List<TestUser>> result = testUserService.getTestUserByPage(pageQuery);
        this.toVm(result, context);
        return "user/testUser/list";
    }


}
