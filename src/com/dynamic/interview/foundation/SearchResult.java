package com.dynamic.interview.foundation;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-12-01
 * @description Comparable的使用, 自身可以与同类进行比较
 */
public class SearchResult implements Comparable<SearchResult> {
    long relativeRatio;
    long count;
    int recentOrders;

    public SearchResult(long relativeRatio, long count) {
        this.count = count;
        this.relativeRatio = relativeRatio;
    }

    @Override
    public int compareTo(SearchResult o) {
        // 先比较相关度
        if (this.relativeRatio != o.relativeRatio) {
            return this.relativeRatio > o.relativeRatio ? 1 : -1;
        }
        // 再比较浏览次数
        if (this.count != o.count) {
            return this.count > o.count ? 1 : -1;
        }
        return 0;
    }

    public void setRecentOrders(int recentOrders) {
        this.recentOrders = recentOrders;
    }
}
