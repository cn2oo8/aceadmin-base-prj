package com.shareyi.jshow.domain.app;

import java.io.Serializable;

/**
 * @author zhangshibin
 * @since 2015-12-7
 * 应用信息 Domain 类
 */
public class JshowApp  implements Serializable {
	
  private static final long serialVersionUID = -3001994064290940509L;
	
	/**  id  */
	private Integer id; 
	/**  名称  */
	private String name; 
	/**  域名  */
	private String domain; 
	/**  状态  */
	private Integer status; 
	/**  创建时间  */
	private java.util.Date created; 
	/**  修改时间  */
	private java.util.Date modified; 

  	public void setId(Integer id) {
  	  this.id=id;
  	}
  
  	public Integer getId() {
  	  return this.id;
  	}
	
	  	

  	public void setName(String name) {
  	  this.name=name;
  	}
  
  	public String getName() {
  	  return this.name;
  	}
	
	  	

  	public void setDomain(String domain) {
  	  this.domain=domain;
  	}
  
  	public String getDomain() {
  	  return this.domain;
  	}
	
	  	

  	public void setStatus(Integer status) {
  	  this.status=status;
  	}
  
  	public Integer getStatus() {
  	  return this.status;
  	}
	
	  	

  	public void setCreated(java.util.Date created) {
  	  this.created=created;
  	}
  
  	public java.util.Date getCreated() {
  	  return this.created;
  	}
	
	  	

  	public void setModified(java.util.Date modified) {
  	  this.modified=modified;
  	}
  
  	public java.util.Date getModified() {
  	  return this.modified;
  	}
	
	  	

}
