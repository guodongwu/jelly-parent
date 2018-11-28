package com.jelly.ssm.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author will
 * @since 2018-11-05
 */
public class Dict implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer dictId;

        /**
     * 键
     */
         private String dictKey;

        /**
     * 值
     */
         private String dictValue;

        /**
     * 名
     */
         private String dictName;

        /**
     * 码
     */
         private String dictCode;

    private LocalDateTime dictTime;

        /**
     * 0启用 1不启用
     */
         private Integer dictStatus;


    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public String getDictKey() {
        return dictKey;
    }

    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public LocalDateTime getDictTime() {
        return dictTime;
    }

    public void setDictTime(LocalDateTime dictTime) {
        this.dictTime = dictTime;
    }

    public Integer getDictStatus() {
        return dictStatus;
    }

    public void setDictStatus(Integer dictStatus) {
        this.dictStatus = dictStatus;
    }

    @Override
    public String toString() {
        return "Dict{" +
        "dictId=" + dictId +
        ", dictKey=" + dictKey +
        ", dictValue=" + dictValue +
        ", dictName=" + dictName +
        ", dictCode=" + dictCode +
        ", dictTime=" + dictTime +
        ", dictStatus=" + dictStatus +
        "}";
    }
}
