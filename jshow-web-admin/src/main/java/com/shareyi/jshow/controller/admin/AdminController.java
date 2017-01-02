package com.shareyi.jshow.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shareyi.jshow.web.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




/**
 * 管理主页
 * @author david
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {

	@RequestMapping("/main")
	public String main(HttpServletRequest request, ModelMap context){
            return "admin/main/admin";
	}



	@RequestMapping(value = "/dialog",method = {RequestMethod.GET,RequestMethod.POST})
	public String dialog(HttpServletRequest request, ModelMap context){
		return "admin/main/dialog";
	}
	
	@RequestMapping(value="logout",method = {RequestMethod.GET,RequestMethod.POST})
	public String logout(HttpServletRequest request, HttpServletResponse response){
	//	cookieUtils.invalidate(request, response);
		return "redirect:/";
	}



}