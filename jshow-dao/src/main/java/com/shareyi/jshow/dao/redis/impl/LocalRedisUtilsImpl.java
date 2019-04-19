package com.shareyi.jshow.dao.redis.impl;

import com.alibaba.fastjson.JSON;
import com.shareyi.jshow.dao.redis.RedisUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * redis工具类
 *
 * @author david
 * @Date 13-11-5
 */

public class LocalRedisUtilsImpl implements RedisUtils {

    /**
     * 分布式redis
     */
    private ShardedJedisPool shardedJedisPool;

    /**
     * 校验key是否存在
     *
     * @param key
     * @return true:存在，false:不存在，如果抛出异常则默认不存在
     */
    @Override
    public boolean checkKeyExists(String key) {
        ShardedJedis jedis = null;
        try {
            jedis = shardedJedisPool.getResource();
            return jedis.exists(key);
        } catch (Exception e) {
//            log.info("MobileRedis->lPush(),队列尾获取元素失败", e);
            return false;
        } finally {
            if (jedis != null) {
                shardedJedisPool.returnResource(jedis);
            }
        }
    }


    /**
     * 以有效期的方式存储对象
     *
     * @param key     存储key
     * @param object  存储对象
     * @param seconds 有效期，秒
     * @return true:保存成功，false:保存失败
     */
    public boolean setObjectByExpire(String key, Object object, int seconds) {
        ShardedJedis jedis = null;
        try {
            jedis = shardedJedisPool.getResource();
            String json = JSON.toJSONString(object);
            jedis.set(key, json);
            jedis.expire(key, seconds);
            return true;
        } catch (Exception e) {
//            log.info("setObjectByExpire(),设置对象失败", e);
            return false;
        } finally {
            if (jedis != null) {
                shardedJedisPool.returnResource(jedis);
            }
        }
    }

    /**
     * 设置key的有效期
     *
     * @param key
     * @param seconds
     * @return
     */
    @Override
    public boolean expire(String key, int seconds) {
        ShardedJedis jedis = null;
        try {
            jedis = shardedJedisPool.getResource();
            jedis.expire(key, seconds);
            return true;
        } catch (Exception e) {
//            log.info("时间设置失败", e);
            return false;
        }
    }



    /**
     * 设置字符串数据至redis
     *
     * @param key   存储Key
     * @param value 存储的值
     * @return true:设置成功，false；设置失败
     */
    @Override
    public boolean setString(String key, String value) {
        ShardedJedis jedis = null;
        try {
            jedis = shardedJedisPool.getResource();
            jedis.set(key, value);
            return true;
        } catch (Exception e) {
//            log.info("setString（）,设置字符串数据失败", e);
            return false;
        } finally {
            if (jedis != null) {
                shardedJedisPool.returnResource(jedis);
            }
        }
    }

    /**
     * 设置带有效期的字符串
     *
     * @param key     存储key
     * @param value   值
     * @param seconds 有效期秒
     * @return true:设置成功，false；设置失败
     */
    @Override
    public boolean setStringByExpire(String key, String value, int seconds) {
        ShardedJedis jedis = null;
        try {
            jedis = shardedJedisPool.getResource();
            jedis.set(key, value);
            jedis.expire(key, seconds);
            return true;
        } catch (Exception e) {
//            log.info("setStringByExpire(),设置字符串失败", e);
            return false;
        } finally {
            if (jedis != null) {
                shardedJedisPool.returnResource(jedis);
            }
        }
    }

    /**
     * 根据key获取字符串信息
     *
     * @param key 存储key
     * @return 如果返回空，则未获取到数据或抛出异常
     */
    @Override
    public String getString(String key) {
        ShardedJedis jedis = null;
        try {
            jedis = shardedJedisPool.getResource();
            return jedis.get(key);
        } catch (Exception e) {
//            log.info("getString,获取字符串失败", e);
            return null;
        } finally {
            if (jedis != null) {
                shardedJedisPool.returnResource(jedis);
            }
        }
    }

    /**
     * 删除指定key
     *
     * @param key
     * @return 如果返回小于0则执行失败
     */
    @Override
    public long deleteByKey(String key) {
        ShardedJedis jedis = null;
        try {
            jedis = shardedJedisPool.getResource();
            if (jedis.exists(key)) {
                return jedis.del(key);
            }
            return -1;
        } catch (Exception e) {
//            log.info("deleteByKey(),删除key失败", e);
            return -1;
        } finally {
            if (jedis != null) {
                shardedJedisPool.returnResource(jedis);
            }
        }
    }

    /**
     * 每次递增key的值
     *
     * @param key
     * @return 如果大于0自增成功，如果小于0自增失败
     */
    @Override
    public long incrString(String key) {
        ShardedJedis jedis = null;
        try {
            jedis = shardedJedisPool.getResource();
            return jedis.incr(key);
        } catch (Exception e) {
//            log.info("incrString(),redis执行变量自增操作失败", e);
            return -1;
        } finally {
            if (jedis != null) {
                shardedJedisPool.returnResource(jedis);
            }
        }
    }


    public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
        this.shardedJedisPool = shardedJedisPool;
    }


}
