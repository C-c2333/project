package com.pj.redis.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * code is far away from bug with the animal protecting
 *
 * @author lishiquan
 * @description Redis的操作接口
 * @date Create in 2018/3/5 23:02
 */
public interface IRedisService {

    /**
     * get值
     *
     * @param key 键
     * @return 是否成功
     */
    Object get(String key);

    /**
     * set值
     *
     * @param key 键
     * @param obj 对象
     */
    void set(String key, Object obj);

    /**
     * set值并且给该key值设置过期时间,单位秒
     *
     * @param key    键
     * @param obj    值
     * @param expire 过期时间
     */
    void set(String key, Object obj, long expire);

    /**
     * 删除
     *
     * @param key 键
     * @return 返回值
     */
    Boolean delete(String key);

    /**
     * 删除
     *
     * @param keys 键的list
     * @return 值
     */
    Long delete(List<String> keys);

    /**
     * 将一个或多个值插入到列表头部
     * 如果 key 不存在，一个空列表会被创建并执行 lPush 操作。 当 key 存在但不是列表类型时，返回一个错误。
     * 注意：在Redis 2.4版本以前的 lPush 命令，都只接受单个 value 值。
     *
     * @param key 键
     * @param obj 值
     * @return 列表的长度
     */
    Long lPush(String key, Object... obj);

    /**
     * 将一个或多个值插入到列表尾部
     * 如果 key 不存在，一个空列表会被创建并执行 rPush 操作。 当 key 存在但不是列表类型时，返回一个错误。
     * 注意：在Redis 2.4版本以前的 rPush 命令，都只接受单个 value 值。
     *
     * @param key 键
     * @param obj 值数组
     * @return 列表的长度
     */
    Long rPush(String key, Object... obj);

    /**
     * Redis lPop 命令用于移除并返回列表的第一个元素。
     *
     * @param key 键
     * @return 列表的第一个元素。 当列表 key 不存在时，返回 nil
     */
    Object lPop(String key);

    /**
     * Redis rPop 命令用于移除并返回列表的最后一个元素。
     *
     * @param key 键
     * @return 列表的最后一个元素。 当列表 key 不存在时，返回 nil
     */
    Object rPop(String key);

    /**
     * 判断该Key是否存在
     *
     * @param key 键
     * @return 是否存在
     */
    Boolean exists(String key);

    /**
     * 根据Key获取剩余时间
     *
     * @param key 键
     * @return 剩余时间
     */
    Long ttl(String key);

    /**
     * 设置过期时间
     *
     * @param key    键
     * @param expire 过期时间
     */
    void expire(String key, long expire);

    /**
     * 实现命令：HGETALL key，返回哈希表 key中，所有的域和值。
     *
     * @param key 键
     * @return 返回值
     */
    Map<Object, Object> hGetAll(String key);

    /**
     * 实现命令：HGET key field，返回哈希表 key中给定域 field的值
     *
     * @param key   键
     * @param field 域
     * @return 返回值
     */
    Object hGet(String key, String field);

    /**
     * 实现命令：HSET key field value，将哈希表 key中的域 field的值设为 value
     *
     * @param key   键
     * @param field 域
     * @param value 值
     */
    void hSet(String key, String field, Object value);

    /**
     * 实现命令：HDEL key field [field ...]，删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
     *
     * @param key    键
     * @param fields 域
     * @return 返回值
     */
    Long hDel(String key, Object... fields);

    /**
     * 实现命令：KEYS pattern，查找所有符合给定模式 pattern的 key
     *
     * @param pattern 匹配串
     * @return 返回值
     */
    Set<String> keys(String pattern);

    /**
     * 自增
     *
     * @param key   键
     * @param delta 步长
     * @return 返回值
     */
    Long incr(String key, long delta);

    /**
     * 自减
     *
     * @param key   键
     * @param delta 步长
     * @return 返回值
     */
    Long decr(String key, long delta);


}
