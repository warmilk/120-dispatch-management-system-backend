package com.emgcy120.core.system.base;

/**
 * Created by weijieliao on 2017/11/29.
 */
public class BasePageReqDto {

    private int pageIndex = 1;
    private int pageSize = 10 ;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
