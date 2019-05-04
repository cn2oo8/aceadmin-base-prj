package com.shareyi.jshow.service.test.impl;

import javax.annotation.Resource;
import com.shareyi.jshow.builder.impl.AcProjectBuilder;
import com.shareyi.jshow.manager.test.AcProjectManager;
import com.shareyi.jshow.service.test.AcProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.shareyi.jshow.domain.test.AcProject;
import com.shareyi.jshow.validate.provide.AcProjectValidator;
import com.shareyi.jshow.service.AbstractService;
import org.springframework.stereotype.Service;

/**
 * AcProject service实现
 *
 * @author MoliCode
 * @date 2019-05-04
 */
@Service("acProjectService")
public class AcProjectServiceImpl extends AbstractService<AcProject> implements AcProjectService {

  protected static final Logger LOGGER = LoggerFactory.getLogger(AcProjectServiceImpl.class);

  /** 验证服务 */
  @Resource(name = "acProjectValidator")
  private AcProjectValidator acProjectValidator;

  /** 数据库代理层 */
  @Resource(name = "acProjectManager")
  private AcProjectManager acProjectManager;

  /** 对象构建器 */
  @Resource(name = "acProjectBuilder")
  private AcProjectBuilder acProjectBuilder;

  /** ***** getter and setter ** */
  @Override
  public AcProjectManager getManager() {
    return acProjectManager;
  }

  @Override
  public AcProjectValidator getValidator() {
    return acProjectValidator;
  }

  @Override
  public AcProjectBuilder getBuilder() {
    return acProjectBuilder;
  }
}
