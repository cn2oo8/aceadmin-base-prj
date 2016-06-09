package com.shareyi.jshow.web.base;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.ui.ModelMap;

import com.shareyi.jshow.common.CommonResult;

public class BaseController {

	
	public void toVm(CommonResult result,ModelMap context){
		this.toVm(result, context, null);
	}
	
	
	public void toVm(CommonResult result,ModelMap context,HttpServletRequest request){
		context.putAll(result.getReturnMap());
	}
	
	
	public int getPageSize(HttpServletRequest request,int defaultPageSize,int max) {
		String pageSizeStr=request.getParameter("pageSize");
    	int pageSize=defaultPageSize;
    	if(StringUtils.isNumeric(pageSizeStr)){
    		try{
    			pageSize=Integer.valueOf(pageSizeStr);
    		}catch (Exception e) {
			}
    		//不能超过最大值
    		pageSize=pageSize>max?max:pageSize;
    	}
		return pageSize;
	}


}
