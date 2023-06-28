package com.iweb.pojo;

public class PageModel {
//    总数据条数
    private int recordCount;
    //当前页数
    private int pageIndex;
    //每页多少条数据
    private int pageSize=4;
    //总页数
    private int totalSize;

    //分页的起始条数
    private int startNum;

    public PageModel() {
    }

    public PageModel(int recordCount, int pageIndex, int pageSize, int totalSize, int startNum) {
        this.recordCount = recordCount;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.startNum = startNum;
    }

    public int getRecordCount() {
        this.recordCount = this.recordCount <=0 ? 0 : this.recordCount;
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getPageIndex() {
        this.pageIndex = this.pageIndex <=0 ? 1 : this.pageIndex;
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

    public int getTotalSize() {
        if (this.getRecordCount()<=0){
            totalSize=0;
        }else {
            totalSize=this.getRecordCount()%this.getPageSize()==0 ? this.getRecordCount()/this.getPageSize() : this.getRecordCount()/this.getPageSize() + 1;
        }
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }
}
