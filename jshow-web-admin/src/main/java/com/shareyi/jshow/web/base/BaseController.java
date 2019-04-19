package com.shareyi.jshow.web.base;

import com.shareyi.jshow.common.CommonResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;

/**
 * 基础的controller
 *
 * @author david
 * @date 2019/4/20
 */
public class BaseController {

    /**
     * 转换到velocity的上下文
     *
     * @param result
     * @param context
     */
    public void toVm(CommonResult result, ModelMap context) {
        this.toVm(result, context, null);
    }


    /**
     * 转换的velocity上下文
     *
     * @param result
     * @param context
     * @param request
     */
    public void toVm(CommonResult result, ModelMap context, HttpServletRequest request) {
        context.putAll(result.getReturnMap());
    }


    /**
     * 从请求中获取pageSize
     *
     * @param request
     * @param defaultPageSize
     * @param max
     * @return
     */
    public int getPageSize(HttpServletRequest request, int defaultPageSize, int max) {
        String pageSizeStr = request.getParameter("pageSize");
        int pageSize = defaultPageSize;
        if (StringUtils.isNumeric(pageSizeStr)) {
            try {
                pageSize = Integer.valueOf(pageSizeStr);
            } catch (Exception e) {
            }
            //不能超过最大值
            pageSize = pageSize > max ? max : pageSize;
        }
        return pageSize;
    }


}
