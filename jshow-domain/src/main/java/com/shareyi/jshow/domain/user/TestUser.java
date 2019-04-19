/**
 * Copyright(c) 2004-2016 www.shareyi.com
 */


package com.shareyi.jshow.domain.user;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;


/**
 * @author david
 * @date 2016-05-21
 * 测试用户 Domain 类
 */
public class TestUser implements Serializable {

    private static final long serialVersionUID = 8770539420222519468L;

    /**
     * id
     */
    private Integer id;
    /**
     * 名字
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 生日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.util.Date birthDay;
    /**
     * 介绍
     */
    private String introduce;
    /**
     * 备注
     */
    private String remark;
    /**
     * 状态
     */
    private Integer state;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private java.util.Date created;
    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private java.util.Date modified;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public java.util.Date getBirthDay() {
        return this.birthDay;
    }

    public void setBirthDay(java.util.Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getIntroduce() {
        return this.introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public java.util.Date getCreated() {
        return this.created;
    }

    public void setCreated(java.util.Date created) {
        this.created = created;
    }

    public java.util.Date getModified() {
        return this.modified;
    }

    public void setModified(java.util.Date modified) {
        this.modified = modified;
    }


}
