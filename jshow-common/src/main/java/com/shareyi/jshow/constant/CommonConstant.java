package com.shareyi.jshow.constant;


/**
 * 常用常量类定义
 *
 * @author david
 */
public class CommonConstant {

    /**
     * 常用YN  1有效
     */
    public static final int STD_YN_YES = 1;
    /**
     * 常用YN  0无效
     */
    public static final int STD_YN_NO = 0;


    /**
     * 标准操作类型，新增
     */
    public static final int STD_OPT_TYPE_ADD = 1;
    /**
     * 标准操作类型，删除
     */
    public static final int STD_OPT_TYPE_DELETE = 2;
    /**
     * 标准操作类型，修改
     */
    public static final int STD_OPT_TYPE_MODIFY = 3;


    /***************************Excel常量定义*******************************/
    /**
     * 导出列表最大条数，目前最大2000条
     */
    public static final int EXPORT_LIST_MAX_SIZE = 2000;


    /**
     * 页面来源参数
     */
    public static final String PAGE_FROM_PARAM_NAME = "from";


    public static final String REQUEST_USER_KEY = "user_key";
}
