package com.ryx.ryxrzt.vo;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author wu
 */
public class BaseVo {
    @ApiModelProperty("token验证")
    private String token;
    @ApiModelProperty("token验证")
    private String total;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    private Integer pageSize;
    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(String pageIndex) {
        this.pageIndex = pageIndex;
    }

    private String pageIndex;
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
