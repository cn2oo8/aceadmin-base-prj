package com.shareyi.jshow.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 公用返还结果
 * @author david
 *
 * @param <T>
 */
public class CommonResult<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public  String modelKey="value";
	
	private boolean success;
	
	private String returnCode;
	
	private String message;
	
	private Map<String,Object> resultMap;
	
	
	
	public CommonResult() {
		this(false);
	}
	
	
	public CommonResult(boolean success) {
		super();
		this.success = success;
		resultMap=new HashMap<String, Object>();
	}

	public void addDefaultModel(T value){
		resultMap.put(modelKey, value);
	}
	
	@SuppressWarnings("unchecked")
	public T getDefaultModel(){
		return (T) resultMap.get(modelKey);
	}
	
	public void addDefaultModel(String key, T value) {
		this.modelKey=key;
		resultMap.put(modelKey, value);
	}
	
	public void addModel(String key,Object value){
		resultMap.put(key, value);
	}
	
	public Object getModel(String key){
		return resultMap.get(key);
	}
	
	
	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}





	public String getReturnCode() {
		return returnCode;
	}





	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}





	public String getMessage() {
		return message;
	}





	public void setMessage(String message) {
		this.message = message;
	}





	public Map<String,Object> getReturnMap(){
		return getReturnMap(false);
	}

	
	//获取结果对象Map 用于json转换
	public Map<String,Object> getReturnMap(boolean isNew){
		Map<String,Object> returnMap=null;
		if(isNew){
			returnMap=new HashMap<String, Object>();
			returnMap.putAll(this.resultMap);
		}else{
			returnMap=this.resultMap;
		}
		returnMap.put("success", this.success);
		returnMap.put("returnCode", this.returnCode);
		returnMap.put("message", this.message);
		
		return returnMap;
	}


}