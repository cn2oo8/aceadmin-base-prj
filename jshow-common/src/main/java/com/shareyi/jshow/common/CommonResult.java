package com.shareyi.jshow.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 公用返还结果
 *
 * @author david
 * @date 2017-01-01
 */
public class CommonResult<T> implements Serializable {

    /**
     * 序列化id
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据key
     */
    public String modelKey = "value";
    /**
     * 成功与否
     */
    private boolean success;
    /**
     * 响应码
     */
    private String returnCode;
    /**
     * 消息
     */
    private String message;
    /**
     * 数据map
     */
    private Map<String, Object> resultMap = new HashMap<String, Object>();

    /**
     * 构建
     */
    public CommonResult() {
        this(false);
    }

    /**
     * 构建
     *
     * @param success
     */
    public CommonResult(boolean success) {
        super();
        this.success = success;
        resultMap = new HashMap<String, Object>();
    }

    /**
     * 构建 +数据
     *
     * @param success
     * @param resultMap
     */
    public CommonResult(boolean success, Map<String, Object> resultMap) {
        super();
        this.success = success;
        this.resultMap = resultMap;
    }

    /**
     * 构建新result
     *
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> create() {
        CommonResult<T> result = new CommonResult<T>();
        return result;
    }

    /**
     * 添加数据到默认模型
     *
     * @param value
     */
    public void addDefaultModel(T value) {
        resultMap.put(modelKey, value);
    }

    /**
     * 获取默认数据结果
     *
     * @return
     */
    public T getDefaultModel() {
        return resultMap == null ? null : (T) resultMap.get(modelKey);
    }

    /**
     * 添加数据到默认模型，并调整key
     *
     * @param key
     * @param value
     */
    public void addDefaultModel(String key, T value) {
        this.modelKey = key;
        resultMap.put(modelKey, value);
    }

    /**
     * 添加其他数据
     *
     * @param key
     * @param value
     */
    public void addModel(String key, Object value) {
        resultMap.put(key, value);
    }

    /**
     * 获取数据
     *
     * @param key
     * @return
     */
    public Object getModel(String key) {
        return resultMap == null ? null : resultMap.get(key);
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

    /**
     * 设置结果信息
     *
     * @param isSuccess
     * @param message
     */
    public CommonResult setResultInfo(boolean isSuccess, String message) {
        this.success = isSuccess;
        this.message = message;
        return this;
    }

    /**
     * 设置结果
     *
     * @param success
     * @param message
     * @param returnCode
     * @return
     */
    public CommonResult setResultInfo(boolean success, String message, String returnCode) {
        this.success = success;
        this.message = message;
        this.returnCode = returnCode;
        return this;
    }

    /**
     * 获取响应map
     *
     * @return
     */
    public Map<String, Object> getReturnMap() {
        return getReturnMap(false);
    }

    /**
     * 获取结果对象Map 用于json转换
     *
     * @param isNew
     * @return
     */
    public Map<String, Object> getReturnMap(boolean isNew) {
        Map<String, Object> returnMap = null;
        if (isNew || resultMap == null) {
            returnMap = new HashMap<String, Object>();
            if (resultMap != null) {
                returnMap.putAll(this.resultMap);
            }
        } else {
            returnMap = this.resultMap;
        }
        returnMap.put("success", this.success);
        returnMap.put("returnCode", this.returnCode);
        returnMap.put("message", this.message);

        return returnMap;
    }

    /**
     * 失败
     *
     * @param message
     * @return
     */
    public CommonResult<T> failed(String message) {
        return result(false, message);
    }

    /**
     * 成功
     *
     * @return
     */
    public CommonResult<T> succeed() {
        return succeed(null);
    }

    /**
     * 成功
     *
     * @param message
     * @return
     */
    public CommonResult<T> succeed(String message) {
        return result(true, message);
    }

    /**
     * 一个新的结果
     *
     * @param success
     * @param message
     * @return
     */
    public CommonResult<T> result(boolean success, String message) {
        this.success = success;
        this.message = message;
        return this;
    }

    /**
     * 获取Raw map数据
     */
    public Map<String, Object> getRawMap() {
        return resultMap;
    }

    /**
     * 合并两个结果
     *
     * @param result
     */
    public void mergeResult(CommonResult result) {
        if (result != null && result.resultMap != null) {
            this.resultMap.putAll(result.resultMap);
        }
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "modelKey='" + modelKey + '\'' +
                ", success=" + success +
                ", returnCode='" + returnCode + '\'' +
                ", message='" + message + '\'' +
                ", resultMap=" + resultMap +
                '}';
    }

}