package com.jelly.ssm.service;

import java.awt.print.Pageable;
import java.io.Serializable;
import java.util.List;

public interface BaseService<T,PK extends Serializable> {
    List<T> query();
    List<T> query(Pageable pageable);
    void add(T t);
    void update(T t);
    T get(PK id);
    void delete(T t);
    void delete(PK id);
}
