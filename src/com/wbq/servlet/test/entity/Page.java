package com.wbq.servlet.test.entity;

/**
 * @ClassName Page
 * @Description 分页实体类
 * @Author wbq
 * @Date 2020/12/15 22:25
 * @Version 1.0
 */
public class Page {
    private Integer pageIndex;
    private Integer pageSize;
    private Integer pageRows;
    private Integer totlePage;
    private Integer startRows;

    public Page(Integer pageIndex) {
        this(pageIndex, 5);
    }

    public Page(Integer pageIndex, Integer pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.setStartRows((pageIndex - 1) * pageSize);
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageRows() {
        return pageRows;
    }

    public void setPageRows(Integer pageRows) {
        this.pageRows = pageRows;
        if (pageRows % pageSize == 0) {
            this.setTotlePage(pageRows % pageSize);
        } else {
            this.setTotlePage(pageRows / pageSize + 1);
        }
    }

    public Integer getTotlePage() {
        return totlePage;
    }

    public void setTotlePage(Integer totlePage) {
        this.totlePage = totlePage;
    }

    public Integer getStartRows() {
        return startRows;
    }

    public void setStartRows(Integer startRows) {
        this.startRows = startRows;
    }
}
