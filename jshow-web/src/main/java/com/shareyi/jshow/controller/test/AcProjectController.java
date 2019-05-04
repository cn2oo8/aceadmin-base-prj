package com.shareyi.jshow.controller.test;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.shareyi.jshow.controller.AbstractController;
import com.shareyi.jshow.service.test.AcProjectService;
import com.shareyi.jshow.domain.test.AcProject;
import javax.servlet.http.HttpServletRequest;

/**
 * AcProject controller
 *
 * @author MoliCode
 * @date 2019-05-04
 */
@Controller
@RequestMapping("/test/acProject")
public class AcProjectController extends AbstractController<AcProject> {

  @Resource(name = "acProjectService")
  private AcProjectService acProjectService;

  public AcProjectService getService() {
    return acProjectService;
  }

  @Override
  protected String getPath() {
    return "/test/acProject";
  }
}
