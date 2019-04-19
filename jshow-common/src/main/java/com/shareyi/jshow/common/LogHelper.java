package com.shareyi.jshow.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志辅助类
 *
 * @author david
 * @date 2019/4/19
 */
public class LogHelper {
    /**
     * 默认日志
     */
    public static final Logger DEFAULT = LoggerFactory.getLogger("defaultLog");

    /**
     * 默认日志
     */
    public static final Logger EXCEPTION = LoggerFactory.getLogger("exceptionLog");


    /**
     * 默认日志
     */
    public static final Logger WARN = LoggerFactory.getLogger("warnLog");

    /**
     * 默认日志
     */
    public static final Logger RPC = LoggerFactory.getLogger("rpcLog");
}
