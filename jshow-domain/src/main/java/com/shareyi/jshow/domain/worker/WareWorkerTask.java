package com.shareyi.jshow.domain.worker;

import java.io.Serializable;

/**
 * @author zhangshibin
 * @since 2014-11-18
 * WareWorkerTask Domain 类
 */
public class WareWorkerTask  implements Serializable {
	
  private static final long serialVersionUID = 1401104534474595274L;
	
	/**  id  */
	private Integer id; 
	/**  事务名称  */
	private String taskName; 
	/**  事务描述  */
	private String taskDesc; 
	/**  起始日期  */
	private java.util.Date startTime; 
	/**  截止日期  */
	private java.util.Date endTime; 
	/**  锁标示 1true 2 false  */
	private Integer lockFlag; 
	/**  运行实例id  */
	private String instanceId; 
	/**  备注  */
	private String remark; 
	/**  创建时间  */
	private java.util.Date created; 
	/**  修改时间  */
	private java.util.Date modified; 
	/**  状态（0.无效,1.有效）  */
	private Integer state; 

  	public void setId(Integer id) {
  	  this.id=id;
  	}
  
  	public Integer getId() {
  	  return this.id;
  	}
	
	  	

  	public void setTaskName(String taskName) {
  	  this.taskName=taskName;
  	}
  
  	public String getTaskName() {
  	  return this.taskName;
  	}
	
	  	

  	public void setTaskDesc(String taskDesc) {
  	  this.taskDesc=taskDesc;
  	}
  
  	public String getTaskDesc() {
  	  return this.taskDesc;
  	}
	
	  	

  	public void setStartTime(java.util.Date startTime) {
  	  this.startTime=startTime;
  	}
  
  	public java.util.Date getStartTime() {
  	  return this.startTime;
  	}
	
	  	

  	public void setEndTime(java.util.Date endTime) {
  	  this.endTime=endTime;
  	}
  
  	public java.util.Date getEndTime() {
  	  return this.endTime;
  	}
	
	  	

  	public void setLockFlag(Integer lockFlag) {
  	  this.lockFlag=lockFlag;
  	}
  
  	public Integer getLockFlag() {
  	  return this.lockFlag;
  	}
	
	  	

  	public void setInstanceId(String instanceId) {
  	  this.instanceId=instanceId;
  	}
  
  	public String getInstanceId() {
  	  return this.instanceId;
  	}
	
	  	

  	public void setRemark(String remark) {
  	  this.remark=remark;
  	}
  
  	public String getRemark() {
  	  return this.remark;
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
	
	  	

  	public void setState(Integer state) {
  	  this.state=state;
  	}
  
  	public Integer getState() {
  	  return this.state;
  	}
	
  	
  	@Override
  	public String toString() {
  		StringBuilder builder=new StringBuilder();
  		builder.append("created=").append(created) .append(",endTime=").append(endTime) .append(",id=").append(id)
  		.append(",instanceId=").append(instanceId) .append(",lockFlag=").append(lockFlag).append(",remark=").
  		append(remark) .append(",startTime=").append(startTime) .append(",state=")
  		.append(state) .append(",taskDesc=").append(taskDesc) .append(",taskName=").append(taskName);
		return builder.toString();
  	}

	public String getTaskInfo() {
		if(taskDesc==null){
			return taskName;
		}
		return taskDesc;
	}

}
