


    package com.manage.hr.util;

import java.util.ArrayList;
import java.util.List;

    public class PageSurport<T> {
        private int pageIndex;//当前页
        private int pageSize;//页大小
        private int totalCount;//总数量
        private int totalPageCount;//总页数
        private List<T>  dataList=new ArrayList<T>();
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
        public int getTotalCount() {
            return totalCount;
        }
        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }
        //计算总页数 只读字段
        public int getTotalPageCount() {
            totalPageCount=totalCount%pageSize==0?totalCount/pageSize:(totalCount/pageSize)+1;
            return totalPageCount;
        }
        /*public void setTotalPageCount(int totalPageCount) {
            this.totalPageCount = totalPageCount;
        }*/
        public List<T> getDataList() {
            return dataList;
        }
        public void setDataList(List<T> dataList) {
            this.dataList = dataList;
        }



    }


