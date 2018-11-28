package com.jelly.ssm.service.impl;

import com.jelly.ssm.dao.BaseMapper;
import com.jelly.ssm.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.io.Serializable;
import java.util.List;

@Service
public class ServiceImpl<T,PK extends  Serializable> implements BaseService<T,PK> {
    @Autowired
    private BaseMapper<T,PK> baseMapper;
    @Override
    public List<T> query() {
        return baseMapper.query();
    }

    @Override
    public List<T> query(Pageable pageable) {
        return baseMapper.query(pageable);
    }

    @Override
    public void add(T t) {
        baseMapper.add(t);
    }

    @Override
    public void update(T t) {
        baseMapper.update(t);
    }

    @Override
    public T get(PK id) {
        return baseMapper.get(id);
    }

    @Override
    public void delete(T t) {
        baseMapper.delete(t);
    }

    @Override
    public void delete(PK id) {
        baseMapper.delete(id);
    }
}
