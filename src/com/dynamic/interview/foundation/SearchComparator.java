package com.dynamic.interview.foundation;

import java.util.Comparator;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-12-01
 * @description Comparator自己只是一个比较器，是一个比较的工具
 */
public class SearchComparator implements Comparator<SearchResult> {
    @Override
    public int compare(SearchResult o1, SearchResult o2) {
        if (o1.relativeRatio != o2.relativeRatio) {
            return o1.relativeRatio > o2.relativeRatio ? 1 : -1;
        }
        if (o1.recentOrders != o2.recentOrders) {
            return o1.recentOrders > o2.recentOrders ? 1 : -1;
        }
        if (o1.count != o2.count) {
            return o1.count > o2.count ? 1 : -1;
        }
        return 0;
    }
}
