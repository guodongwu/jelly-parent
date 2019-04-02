package com.ryx.common;

import java.awt.print.Pageable;
import java.io.Serializable;
import java.util.List;

/**
 * 通用mapper
 * @author RYX
 * @param <T>
 * @param <PK>
 */
public interface BaseMapper<T,PK extends Serializable> {

    List<T> query();
    List<T> query(Pageable pageable);
    void insert(T t);
    void update(T t);
    T get(PK id);
    void delete(T t);
    void delete(PK id);
}
