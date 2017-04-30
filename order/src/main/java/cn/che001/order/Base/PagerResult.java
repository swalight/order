package cn.che001.order.Base;

import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页返回值，结合PageHelper插件
 * light
 */
public class PagerResult {
    private long pageNumber;
    private long pageSize;
    private long pagesCount;
    private long totalItemsCount;
    private List items;

    public PagerResult(PageInfo pageInfo) {
        this.items = pageInfo.getList()==null?new ArrayList():pageInfo.getList();
        this.totalItemsCount = pageInfo.getTotal();
        this.pageNumber = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.pagesCount = pageInfo.getPages();
    }

    public long getPageNumber() {
        return this.pageNumber;
    }

    public long getPageSize() {
        return this.pageSize;
    }

    public long getPagesCount() {
        return this.pagesCount;
    }

    public long getTotalItemsCount() {
        return this.totalItemsCount;
    }

    public List getItems() {
        return this.items;
    }

}