package com.shareyi.jshow.controller.html5;

import com.shareyi.jshow.web.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 上传工具服务
 *
 * @author david
 * @date 2015/12/27.
 */
@Controller
@RequestMapping("/html5")
public class AppController extends BaseController {


    @RequestMapping("/fileUpload")
    public String htmlFileUpload() {
        return "html5/fileUpload";
    }
}
