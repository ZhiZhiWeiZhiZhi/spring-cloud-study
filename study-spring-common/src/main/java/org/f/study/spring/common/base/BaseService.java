package org.f.study.spring.common.base;

import java.util.List;

/**
 * Created by f on 2017/9/19.
 */
public interface BaseService<T>{

    /**
     * 保存和修改合成一个方法，根据id是否为空判断是否是新增还是修改
     * 自动设置UUID
     * @param t
     * @return
     */
    int save(T t);

    /**
     * 安全获取，多个时获取创建时间最早的一个
     * @param t
     * @return
     */
    T selectOneSafe(T t);


    /**
     * 安全删除，修改deleteState=1
     * @param t
     * @return
     */
    int deleteByPrimaryKeySafe(T t);


    int deleteByPrimaryKey(Object o);
    int delete(T t);
    int insert(T t);
    int insertSelective(T t);
    boolean existsWithPrimaryKey(Object o);
    List<T> selectAll();
    T selectByPrimaryKey(Object o);
    int selectCount(T t);
    List<T> select(T t);
    T selectOne(T t);
    int updateByPrimaryKey(T t);
    int updateByPrimaryKeySelective(T t);
    int deleteByExample(Object o);
    List<T> selectByExample(Object o);
    int selectCountByExample(Object o);
    int updateByExample(T t, Object o);
    int updateByExampleSelective(T t, Object o);
}
