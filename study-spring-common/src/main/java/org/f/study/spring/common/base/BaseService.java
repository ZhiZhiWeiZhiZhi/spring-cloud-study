package org.f.study.spring.common.base;

import java.util.List;

/**
 * Created by f on 2017/9/19.
 */
public interface BaseService<T>{
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
