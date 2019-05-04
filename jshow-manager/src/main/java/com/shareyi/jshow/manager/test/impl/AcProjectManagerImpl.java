package com.shareyi.jshow.manager.test.impl;

import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import com.shareyi.jshow.domain.test.AcProject;
import com.shareyi.jshow.dao.test.AcProjectDao;
import com.shareyi.jshow.manager.test.AcProjectManager;
import com.shareyi.jshow.manager.AbstractManager;
import com.shareyi.jshow.builder.impl.AcProjectBuilder;
/**
 * AcProjectManager实现类
 *
 * @author MoliCode
 * @date 2019-05-04
 */
@Component("acProjectManager")
public class AcProjectManagerImpl extends AbstractManager<AcProject> implements AcProjectManager {

  /** 访问层 */
  @Resource private AcProjectDao acProjectDao;
  /** bean构建服务 */
  @Resource(name = "acProjectBuilder")
  AcProjectBuilder acProjectBuilder;

  /** ***** getter and setter ** */
  @Override
  public AcProjectBuilder getBuilder() {
    return acProjectBuilder;
  }

  @Override
  public AcProjectDao getDao() {
    return acProjectDao;
  }
}
