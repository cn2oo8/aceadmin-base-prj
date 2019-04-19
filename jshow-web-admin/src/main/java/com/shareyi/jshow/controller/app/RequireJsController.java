package com.shareyi.jshow.controller.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用于测试requireJS相关技术
 *
 * @author david on 2016/4/17.
 */

@Controller
@RequestMapping("/app/requireJs")
public class RequireJsController {


    @RequestMapping(value = "main", method = {RequestMethod.GET, RequestMethod.POST})
    public String main() {

        return "/app/requireJs/main";

    }
}
