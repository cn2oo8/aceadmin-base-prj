/**
 * 
 */
package com.shareyi.jshow.common;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;




/**
 * @author david
 *
 */
public class PageQuery {
	
	public static final String CURRENT_PAGE = "page";
	public static final String DIRECTION_ASC = "ASC";
	public static final String DIRECTION_DESC = "DESC";
	
	private int currentPageNo;
	private int pageSize = 10;
	private int startIndex;
	private int startRow;
	private int totalCount;
	private int pageCount;
	private String orderBy;
	private String direction;
	private Map<String, Object> params = new HashMap<String, Object>();
	private HttpServletRequest request;
	
	public PageQuery() {
		this(10);
	}
	
	public PageQuery(int pageSize) {
		this(((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).
				getRequest(), pageSize);
	}
	
	public PageQuery(HttpServletRequest request) {
		this.setRequest(request);
	}
	
	public PageQuery(HttpServletRequest request, int pageSize) {
		this.setRequest(request);
		this.pageSize = pageSize;
		this.params = getParameterNameValuesMap(request);
	}
	
	public PageQuery(int pageSize, Map<String, Object> params) {
		this.pageSize = pageSize;
		this.params = params;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getStartIndex() {
		startIndex = (getCurrentPageNo() - 1) * pageSize;
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.init();
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}


	public int getCurrentPageNo() {
		if(currentPageNo!=0){
			return currentPageNo;
		}
		
		String cpn = String.valueOf(this.params.get(PageQuery.CURRENT_PAGE));
		if (StringUtils.isBlank(cpn) || !StringUtils.isNumeric(cpn) || cpn.length() > 11) {
			cpn = "1";
		}
		currentPageNo = Integer.parseInt(cpn);
		if (currentPageNo < 1) currentPageNo = 1;
		if (currentPageNo > pageCount) currentPageNo = pageCount;
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}
	
	
	private void init() {
		pageCount = (int) totalCount / pageSize;
		if (totalCount % pageSize > 0 || pageCount == 0) {
			pageCount++;
		}
		
		// 把与分页相关的数据放入Map用于查询
		params.put("startIndex", getStartIndex());
		params.put("startRow", getStartIndex());
		params.put("pageSize", getPageSize());
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public int getStartRow() {
		startRow = this.getStartIndex();
        return startRow;
    }
	
	public void setStartRow(int startRow) {
		this.setStartIndex(startRow);
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
		params.put("order_by", this.getOrderBy());
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
		params.put("sort_type", this.getDirection());
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getParameterNameValuesMap(HttpServletRequest request) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		Enumeration<String> names = (Enumeration<String>) request.getParameterNames();
		StringBuilder pvalues = null;
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String[] values = request.getParameterValues(name);
			if (values != null) {
				for (String value : values) {
					pvalues = new StringBuilder();
					pvalues.append(value);
					pvalues.append(",");
				}
				pvalues.deleteCharAt(pvalues.lastIndexOf(","));
				paramsMap.put(name, pvalues.toString());
			}
		}
		return paramsMap;
	}
	
	/**
	 * 添加查询参数
	 * 
	 * @param name
	 * @param value
	 */
	public void addQueryParam(String name, Object value) {
		params.put(name, value);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map getParamExceptPage() {
		Map map = new HashMap();
		map.putAll(params);
		map.remove("order_by");
		map.remove("startIndex");
		map.remove("startRow");
		map.remove("pageSize");
		map.remove("sort_type");
		return map;
	}

}
