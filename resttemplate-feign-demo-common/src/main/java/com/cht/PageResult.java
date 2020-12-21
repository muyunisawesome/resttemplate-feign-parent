package com.cht;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int totalCount;
    private int pageSize;
    private int currPage;
    private List<T> list;
    private boolean hasMore;

    public PageResult() {
    }

    public PageResult(List<T> list, int totalCount, int pageSize, int currPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
    }

    public PageResult(List<T> list, int totalCount, int pageSize) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
    }

    public PageResult(int currPage, int pageSize) {
        this.currPage = currPage;
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrPage() {
        return this.currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public List<T> getList() {
        if (this.list == null || this.list.isEmpty()) {
            this.list = new ArrayList(0);
        }

        return this.list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public boolean isHasMore() {
        if (this.totalCount - this.currPage * this.pageSize > 0) {
            this.hasMore = true;
        } else {
            this.hasMore = false;
        }

        return this.hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }
}
