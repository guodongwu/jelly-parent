package com.jelly.redis.study.utils;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Redis 工具类
 * @author wu
 * @date 2019
 */
public class RedisUtils {
    private StringRedisTemplate redisTemplate;
    public  void setRedisTemplate(StringRedisTemplate redisTemplate){
        this.redisTemplate=redisTemplate;
    }
    /*-----------key相关操作------------*/

    /**
     * 删除key
     * @param key
     */
    public  void delete(String key){
        redisTemplate.delete(key);
    }

    /**
     * 批量删除key
     * @param keys
     */
    public  void delete(Collection<String> keys){
        redisTemplate.delete(keys);
    }

    /**
     * 序列化key
     * @param key
     * @return
     */
    public  byte[] dump(String key){
        return  redisTemplate.dump(key);
    }

    /**
     * 是否存在key
     * @param key
     * @return
     */
    public  Boolean hasKey(String key){
        return  redisTemplate.hasKey(key);
    }

    /**
     * 设置过期时间
     * @param key
     * @param timeout
     * @param timeUnit
     * @return
     */
    public  Boolean expire(String key, long timeout, TimeUnit timeUnit){
        return  redisTemplate.expire(key,timeout,timeUnit);
    }

    /**
     * 设置过期时间
     * @param key
     * @param date
     * @return
     */
    public  Boolean expireAt(String key, Date date){
        return redisTemplate.expireAt(key,date);
    }

    /**
     * 匹配查找key
     * @param pattern
     * @return
     */
    public Set<String> keys(String pattern){
        return  redisTemplate.keys(pattern);
    }

    /**
     * 移动当前key 到 指定的db中
     * @param key
     * @param dbIndex
     * @return
     */
    public  Boolean move(String key,int dbIndex){
        return  redisTemplate.move(key,dbIndex);
    }

    /**
     * 移除过期时间 保持持久化
     * @param key
     * @return
     */
    public  Boolean persist(String key){
        return  redisTemplate.persist(key);
    }

    /**
     * 返回key 的剩余过期时间
     * @param key
     * @param timeUnit
     * @return
     */
    public  Long getExpire(String key,TimeUnit timeUnit){
        return  redisTemplate.getExpire(key,timeUnit);
    }

    /**
     * 返回过期时间
     * @param key
     * @return
     */
    public  Long getExpire(String key){
        return  redisTemplate.getExpire(key);
    }

    /**
     * 返回随机的key
     * @return
     */
    public  String randomKey(){
        return  redisTemplate.randomKey();
    }

    /**
     * 重新命名key
     * @param oldKey
     * @param newKey
     */
    public void rename(String oldKey,String newKey){
        redisTemplate.rename(oldKey,newKey);
    }

    /**
     * 当newKey不存在时 将oldKey改名为newKey
     * @param oldKey
     * @param newKey
     * @return
     */
    public  Boolean renameIfAbsent(String oldKey,String newKey){
        return redisTemplate.renameIfAbsent(oldKey,newKey);
    }

    /**
     * 返回key所存储的值的类型
     * @param key
     * @return
     */
    public DataType type(String key){
        return  redisTemplate.type(key);
    }
    /*------------String 相关操作-------------------*/

    /**
     * 设置key的值
     * @param key
     * @param value
     */
    public  void set (String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * 获取指定key的值
     * @param key
     * @return
     */
    public String get (String key){
       return redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取key中字符串的字字符
     * @param key
     * @param start
     * @param end
     * @return
     */
    public  String getRange(String key,long start,long end){
        return redisTemplate.opsForValue().get(key,start,end);
    }

    /**
     * 获取旧值,设置新值
     * @param key
     * @param value
     * @return
     */
    public  String getAndSet(String key,String value){
        return  redisTemplate.opsForValue().getAndSet(key,value);
    }

    /**
     * 对 key 所储存的字符串值，获取指定偏移量上的位(bit)
     * @param key
     * @param offset
     * @return
     */
    public  Boolean getBit(String key,long offset){
        return  redisTemplate.opsForValue().getBit(key,offset);
    }

    /**
     * 批量获取值
     * @param keys
     * @return
     */
    public List<String> multGet(Collection<String> keys){
        return  redisTemplate.opsForValue().multiGet(keys);
    }

    /**
     * 设置ASCII码, 字符串'a'的ASCII码是97, 转为二进制是'01100001',
     * 此方法是将二进制第offset位值变为value
     * @param key
     * @param offset
     * @param value
     * @return
     */
    public  Boolean setBit(String key,long offset,boolean value){
        return  redisTemplate.opsForValue().setBit(key, offset, value);
    }

    /**
     * 设置key的值 并设置过期时间
     * @param key
     * @param value
     * @param timeout
     * @param unit
     */
    public  void set(String key,String value,long timeout,TimeUnit unit){
        redisTemplate.opsForValue().set(key,value,timeout,unit);
    }

    /**
     * 如果不存在则设置key的值
     * @param key
     * @param value
     * @return
     */
    public  Boolean setIfAbsent(String key,String value){
        return  redisTemplate.opsForValue().setIfAbsent(key,value);
    }

    /**
     * 在指定位置覆写值
     * @param key
     * @param value
     * @param offset
     */
    public void setRange(String key,String value,long offset){
        redisTemplate.opsForValue().set(key, value, offset);
    }

    /**
     * 获取值的size
     * @param key
     * @return
     */
    public Long size(String key){
        return  redisTemplate.opsForValue().size(key);
    }

    /**
     * 批量添加
     * @param maps
     */
    public  void multSet(Map<String,String> maps){
        redisTemplate.opsForValue().multiSet(maps);
    }

    /**
     * 同时设置一个或多个 key-value 对，当且仅当所有给定 key 都不存在
     * @param maps
     * @return
     */
    public  boolean multSetIfAbsent(Map<String,String> maps){
        return  redisTemplate.opsForValue().multiSetIfAbsent(maps);
    }

    /**
     * 增加 子增长
     * @param key
     * @param increment
     * @return
     */
    public  Long incrBy(String key,long increment){
        return  redisTemplate.opsForValue().increment(key, increment);
    }

    /**
     * 自增
     * @param key
     * @param increment
     * @return
     */
    public  Double incrByFloat(String key,double increment){
        return  redisTemplate.opsForValue().increment(key,increment);
    }

    /**
     * 追加到末尾
     * @param key
     * @param value
     * @return
     */
    public  Integer append(String key,String value){
        return  redisTemplate.opsForValue().append(key,value);
    }


    /*-------------hash相关操作--------------*/

    /**
     * 获取存储在hash表中的指定值
     * @param key
     * @param field
     * @return
     */
    public  Object hGet(String key,String field){
        return  redisTemplate.opsForHash().get(key,field);
    }

    /**
     * 获取所有的值
     * @param key
     * @return
     */
    public Map<Object,Object> hGetAll(String  key){
        return  redisTemplate.opsForHash().entries(key);
    }

    /**
     * 获取所有给定字段的值
     * @param key
     * @param fields
     * @return
     */
    public  List<Object> hMultGet(String key,Collection<Object> fields){
        return  redisTemplate.opsForHash().multiGet(key,fields);
    }

    /**
     * 设置值
     * @param key
     * @param hashKey
     * @param value
     */
    public  void hPut(String key,String hashKey,String value){
        redisTemplate.opsForHash().put(key,hashKey,value);
    }

    /**
     *
     * @param key
     * @param maps
     */
    public  void hPutAll(String key,Map<?,?> maps){
        redisTemplate.opsForHash().putAll(key,maps);
    }

    /**
     * 不存在则设置
     * @param key
     * @param hashKey
     * @param value
     * @return
     */
    public Boolean hPutIfAbsent(String key,String hashKey,String value){
        return  redisTemplate.opsForHash().putIfAbsent(key,hashKey,value);
    }

    /**
     * 删除一个或多个哈希表字段
     * @param key
     * @param fields
     * @return
     */
    public  Long hDelete(String key,Object... fields){
        return  redisTemplate.opsForHash().delete(key,fields);
    }
    /**
     * 是否存在
     */
    public  Boolean hExists(String key,String field){
        return redisTemplate.opsForHash().hasKey(key,field);
    }

    /**
     * 增加
     * @param key
     * @param field
     * @param increment
     * @return
     */
    public  Long hIncrBy(String key,Object field,long increment){
        return redisTemplate.opsForHash().increment(key,field,increment);
    }
    public  Double hIncrByFloat(String key,Object field ,double delta){
        return redisTemplate.opsForHash().increment(key, field, delta);
    }
    public  Set<Object> hKeys(String key){
        return redisTemplate.opsForHash().keys(key);
    }
    public  Long hSize(String key){
        return redisTemplate.opsForHash().size(key);
    }
    public List<Object> hValues(String key){
        return redisTemplate.opsForHash().values(key);
    }
    public Cursor<Map.Entry<Object,Object>> hScan(String key, ScanOptions options){
        return redisTemplate.opsForHash().scan(key,options);
    }
    /*------------list 相关操作--------------*/

    /**
     * 通过索引获取列表
     * @param key
     * @param index
     * @return
     */
    public  String lIndex(String key,long index){
        return redisTemplate.opsForList().index(key, index);
    }
    public  List<String> lRange(String key,long start,long end){
        return redisTemplate.opsForList().range(key,start,end);
    }
    public Long lLeftPush(String key,String value){
        return  redisTemplate.opsForList().leftPush(key,value);
    }
    public Long lLeftPushAll(String key,String...value){
        return redisTemplate.opsForList().leftPushAll(key,value);
    }
    public Long lLeftPushAll(String key,Collection<String> value){
        return redisTemplate.opsForList().leftPushAll(key,value);
    }
    public Long lLeftPushIfPresent(String key,String value){
        return  redisTemplate.opsForList().leftPushIfPresent(key,value);
    }
    public Long lLeftPush(String key,String pivot,String value){
        return redisTemplate.opsForList().leftPush(key,pivot,value);
    }
    public  Long iRightPush(String key,String value){
        return redisTemplate.opsForList().rightPush(key,value);
    }
    public Long lRightPushAll(String  key,String...value){
        return  redisTemplate.opsForList().rightPushAll(key, value);
    }
    public Long lRightPushAll(String key,Collection<String> value){
        return redisTemplate.opsForList().rightPushAll(key,value);
    }
    public Long lRightPushIfPresent(String key,String value){
        return  redisTemplate.opsForList().rightPushIfPresent(key,value);
    }
    public Long lRightPush(String key,String pivot,String value){
        return redisTemplate.opsForList().rightPush(key, pivot, value);
    }
    public  void lSet(String key,long index,String value){
        redisTemplate.opsForList().set(key, index, value);
    }
    public  String lLeftPop(String key){
        return redisTemplate.opsForList().leftPop(key);
    }
    public  String lBLeftPop(String key,long timeout,TimeUnit unit){
        return redisTemplate.opsForList().leftPop(key, timeout, unit);
    }
    public  String lRightPop(String key){
        return  redisTemplate.opsForList().rightPop(key);
    }
    public String lRightPopAndLeftPush(String sourceKey,String destinationKey){
        return  redisTemplate.opsForList().rightPopAndLeftPush(sourceKey, destinationKey);
    }
    public String lBRightPopAndLeftPush(String sourceKey, String destinationKey,
                                        long timeout, TimeUnit unit) {
        return redisTemplate.opsForList().rightPopAndLeftPush(sourceKey,
                destinationKey, timeout, unit);
    }
    public  Long lRemove(String key,long index,String value){
        return  redisTemplate.opsForList().remove(key,index,value);
    }
    public  void lTrim(String key,long start,long end){
        redisTemplate.opsForList().trim(key, start, end);
    }
    public  Long lLen(String key){
        return  redisTemplate.opsForList().size(key);
    }
    /*---------------set 相关操作-------------*/

    public  Long sAdd(String key ,String...values){
        return  redisTemplate.opsForSet().add(key,values);
    }
    public  Long sRemove(String key){
        return  redisTemplate.opsForSet().remove(key);
    }
    public  String sPop(String key){
        return redisTemplate.opsForSet().pop(key);
    }
    public Boolean sMove(String key,String value,String destKey){
        return  redisTemplate.opsForSet().move(key, value, destKey);
    }
    public  Long sSize(String key){
        return  redisTemplate.opsForSet().size(key);
    }
    public  Boolean sIsMember(String key,Object value)
    {
        return  redisTemplate.opsForSet().isMember(key,value);
    }
    public  Set<String> sIntersect(String key,String otherKey){
        return redisTemplate.opsForSet().intersect(key,otherKey);
    }
    public Long sIntersectAndStore(String key,Collection<String> otherKey,String destKey){
        return redisTemplate.opsForSet().intersectAndStore(key, otherKey, destKey);
    }
    public  Set<String> sUnion(String key,String otherKey){
        return redisTemplate.opsForSet().union(key, otherKey);
    }
    public Set<String> sUnion(String key,Collection<String> otherKeys){
        return redisTemplate.opsForSet().union(key, otherKeys);
    }
    public Long sUnionAndStore(String key,String otherKey,String destKey){
        return  redisTemplate.opsForSet().unionAndStore(key, otherKey, destKey);
    }
    public Long sUnionAndStore(String key,Collection<String> otherKeys,String destKey){
        return  redisTemplate.opsForSet().unionAndStore(key, otherKeys, destKey);
    }
    public Set<String> sDifference(String key,String otherKey){
        return  redisTemplate.opsForSet().difference(key,otherKey);
    }
    public Set<String> sDifference(String key,Collection<String> otherKeys){
        return  redisTemplate.opsForSet().difference(key, otherKeys);
    }
    public  Long sDifference(String key,String otherKey,String destKey){
        return redisTemplate.opsForSet().differenceAndStore(key, otherKey, destKey);
    }
    public  Long sDifference(String key,Collection<String> otherKeys,String destKey){
        return  redisTemplate.opsForSet().differenceAndStore(key, otherKeys, destKey);
    }
    public String sRandomMember(String key){
        return  redisTemplate.opsForSet().randomMember(key);
    }
    public List<String> sRandomMember(String key,long count){
        return  redisTemplate.opsForSet().randomMembers(key,count);
    }
    public  Set<String> sDistinctRandomMembers(String key,long count){
        return  redisTemplate.opsForSet().distinctRandomMembers(key, count);
    }
    public Cursor<String> sScan(String key,ScanOptions options){
        return  redisTemplate.opsForSet().scan(key, options);
    }
    /*-------------zSet相关操作------------*/

    public  Boolean zAdd(String key,String value,double score){
        return redisTemplate.opsForZSet().add(key, value, score);
    }
    public  Long zAdd(String key, Set<ZSetOperations.TypedTuple<String>> value){
        return redisTemplate.opsForZSet().add(key, value);

    }

    /**
     *
     * @param key
     * @param values
     * @return
     */
    public Long zRemove(String key, Object... values) {
        return redisTemplate.opsForZSet().remove(key, values);
    }

    /**
     * 增加元素的score值，并返回增加后的值
     *
     * @param key
     * @param value
     * @param delta
     * @return
     */
    public Double zIncrementScore(String key, String value, double delta) {
        return redisTemplate.opsForZSet().incrementScore(key, value, delta);
    }

    /**
     * 返回元素在集合的排名,有序集合是按照元素的score值由小到大排列
     *
     * @param key
     * @param value
     * @return 0表示第一位
     */
    public Long zRank(String key, Object value) {
        return redisTemplate.opsForZSet().rank(key, value);
    }

    /**
     * 返回元素在集合的排名,按元素的score值由大到小排列
     *
     * @param key
     * @param value
     * @return
     */
    public Long zReverseRank(String key, Object value) {
        return redisTemplate.opsForZSet().reverseRank(key, value);
    }

    /**
     * 获取集合的元素, 从小到大排序
     *
     * @param key
     * @param start
     *            开始位置
     * @param end
     *            结束位置, -1查询所有
     * @return
     */
    public Set<String> zRange(String key, long start, long end) {
        return redisTemplate.opsForZSet().range(key, start, end);
    }

    /**
     * 获取集合元素, 并且把score值也获取
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<ZSetOperations.TypedTuple<String>> zRangeWithScores(String key, long start,
                                                                   long end) {
        return redisTemplate.opsForZSet().rangeWithScores(key, start, end);
    }

    /**
     * 根据Score值查询集合元素
     *
     * @param key
     * @param min
     *            最小值
     * @param max
     *            最大值
     * @return
     */
    public Set<String> zRangeByScore(String key, double min, double max) {
        return redisTemplate.opsForZSet().rangeByScore(key, min, max);
    }

    /**
     * 根据Score值查询集合元素, 从小到大排序
     *
     * @param key
     * @param min
     *            最小值
     * @param max
     *            最大值
     * @return
     */
    public Set<ZSetOperations.TypedTuple<String>> zRangeByScoreWithScores(String key,
                                                                          double min, double max) {
        return redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max);
    }

    /**
     *
     * @param key
     * @param min
     * @param max
     * @param start
     * @param end
     * @return
     */
    public Set<ZSetOperations.TypedTuple<String>> zRangeByScoreWithScores(String key,
                                                                          double min, double max, long start, long end) {
        return redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max,
                start, end);
    }

    /**
     * 获取集合的元素, 从大到小排序
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<String> zReverseRange(String key, long start, long end) {
        return redisTemplate.opsForZSet().reverseRange(key, start, end);
    }

    /**
     * 获取集合的元素, 从大到小排序, 并返回score值
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<ZSetOperations.TypedTuple<String>> zReverseRangeWithScores(String key,
                                                                          long start, long end) {
        return redisTemplate.opsForZSet().reverseRangeWithScores(key, start,
                end);
    }

    /**
     * 根据Score值查询集合元素, 从大到小排序
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set<String> zReverseRangeByScore(String key, double min,
                                            double max) {
        return redisTemplate.opsForZSet().reverseRangeByScore(key, min, max);
    }

    /**
     * 根据Score值查询集合元素, 从大到小排序
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Set<ZSetOperations.TypedTuple<String>> zReverseRangeByScoreWithScores(
            String key, double min, double max) {
        return redisTemplate.opsForZSet().reverseRangeByScoreWithScores(key,
                min, max);
    }

    /**
     *
     * @param key
     * @param min
     * @param max
     * @param start
     * @param end
     * @return
     */
    public Set<String> zReverseRangeByScore(String key, double min,
                                            double max, long start, long end) {
        return redisTemplate.opsForZSet().reverseRangeByScore(key, min, max,
                start, end);
    }

    /**
     * 根据score值获取集合元素数量
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Long zCount(String key, double min, double max) {
        return redisTemplate.opsForZSet().count(key, min, max);
    }

    /**
     * 获取集合大小
     *
     * @param key
     * @return
     */
    public Long zSize(String key) {
        return redisTemplate.opsForZSet().size(key);
    }

    /**
     * 获取集合大小
     *
     * @param key
     * @return
     */
    public Long zZCard(String key) {
        return redisTemplate.opsForZSet().zCard(key);
    }

    /**
     * 获取集合中value元素的score值
     *
     * @param key
     * @param value
     * @return
     */
    public Double zScore(String key, Object value) {
        return redisTemplate.opsForZSet().score(key, value);
    }

    /**
     * 移除指定索引位置的成员
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Long zRemoveRange(String key, long start, long end) {
        return redisTemplate.opsForZSet().removeRange(key, start, end);
    }

    /**
     * 根据指定的score值的范围来移除成员
     *
     * @param key
     * @param min
     * @param max
     * @return
     */
    public Long zRemoveRangeByScore(String key, double min, double max) {
        return redisTemplate.opsForZSet().removeRangeByScore(key, min, max);
    }

    /**
     * 获取key和otherKey的并集并存储在destKey中
     *
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    public Long zUnionAndStore(String key, String otherKey, String destKey) {
        return redisTemplate.opsForZSet().unionAndStore(key, otherKey, destKey);
    }

    /**
     *
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    public Long zUnionAndStore(String key, Collection<String> otherKeys,
                               String destKey) {
        return redisTemplate.opsForZSet()
                .unionAndStore(key, otherKeys, destKey);
    }

    /**
     * 交集
     *
     * @param key
     * @param otherKey
     * @param destKey
     * @return
     */
    public Long zIntersectAndStore(String key, String otherKey,
                                   String destKey) {
        return redisTemplate.opsForZSet().intersectAndStore(key, otherKey,
                destKey);
    }

    /**
     * 交集
     *
     * @param key
     * @param otherKeys
     * @param destKey
     * @return
     */
    public Long zIntersectAndStore(String key, Collection<String> otherKeys,
                                   String destKey) {
        return redisTemplate.opsForZSet().intersectAndStore(key, otherKeys,
                destKey);
    }

    /**
     *
     * @param key
     * @param options
     * @return
     */
    public Cursor<ZSetOperations.TypedTuple<String>> zScan(String key, ScanOptions options) {
        return redisTemplate.opsForZSet().scan(key, options);
    }




















}

