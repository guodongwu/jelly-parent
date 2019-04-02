package com.ryx.ryxpay.service;

import com.ryx.ryxpay.entity.RyxTermBrand;

import java.util.List;

public interface DictionaryService {
    public List<RyxTermBrand> selectRyxTermBrandList(RyxTermBrand ryxTermBrand);
}
