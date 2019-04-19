package com.shareyi.jshow.dao.redis;

/**
 * redis工具类
 *
 * @author david
 * @Date 2017-01-01
 */
public interface RedisUtils {

    /**
     * 校验key是否存在
     *
     * @param key
     * @return true:存在，false:不存在，如果抛出异常则默认不存在
     */
    boolean checkKeyExists(String key);

    /**
     * 设置字符串数据至redis
     *
     * @param key   存储Key
     * @param value 存储的值
     * @return true:设置成功，false；设置失败
     */
    boolean setString(String key, String value);

    /**
     * 设置带有效期的字符串
     *
     * @param key     存储key
     * @param value   值
     * @param seconds 有效期秒
     * @return true:设置成功，false；设置失败
     */
    boolean setStringByExpire(String key, String value, int seconds);

    /**
     * 设置key的有效期
     *
     * @param key
     * @param seconds
     * @return
     */
    boolean expire(String key, int seconds);

    /**
     * 根据key获取字符串信息
     *
     * @param key 存储key
     * @return 如果返回空，则未获取到数据或抛出异常
     */
    String getString(String key);

    /**
     * 删除指定key
     *
     * @param key
     * @return 如果返回小于0则执行失败
     */
    long deleteByKey(String key);

    /**
     * 每次递增key的值
     *
     * @param key
     * @return 如果大于0自增成功，如果小于0自增失败
     */
    long incrString(String key);

}
