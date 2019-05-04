package com.shareyi.jshow.builder.impl;

import com.shareyi.jshow.builder.AbstractBuilder;
import com.shareyi.jshow.domain.test.AcProject;
import org.springframework.stereotype.Service;

/**
 * AcProject Builder 类
 *
 * @author MoliCode
 * @date 2019-05-04
 */
@Service("acProjectBuilder")
public class AcProjectBuilder extends AbstractBuilder<AcProject> {

  @Override
  public String getBizName() {
    return "AcProject";
  }

  @Override
  public Class getBizClass() {
    return AcProject.class;
  }
}
