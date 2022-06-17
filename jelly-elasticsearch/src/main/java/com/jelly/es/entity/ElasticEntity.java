package com.jelly.es.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class ElasticEntity implements Serializable {
    private String id;
    private Map data;
}
