package com.shareyi.jshow.validate.provide;

import static com.shareyi.jshow.common.valid.Validate.*;
import com.shareyi.jshow.validate.AbstractValidator;
import org.springframework.stereotype.Service;
import com.shareyi.jshow.domain.test.AcProject;

/**
 * AcProject SDK 验证 类
 *
 * @author MoliCode
 * @date 2019-05-04
 */
@Service("acProjectValidator")
public class AcProjectValidator extends AbstractValidator<AcProject> {}
