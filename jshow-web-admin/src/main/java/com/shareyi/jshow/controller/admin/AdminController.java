package com.shareyi.jshow.controller.admin;

import com.shareyi.jshow.web.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 管理主页controller
 *
 * @author david
 * @date 2019-04-01
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @RequestMapping("/main")
    public String main() {
        return "admin/main/admin";
    }


    @RequestMapping(value = "/dialog", method = {RequestMethod.GET, RequestMethod.POST})
    public String dialog() {
        return "admin/main/dialog";
    }

    @RequestMapping(value = "logout", method = {RequestMethod.GET, RequestMethod.POST})
    public String logout() {
        //	cookieUtils.invalidate(request, response);
        return "redirect:/";
    }


}
