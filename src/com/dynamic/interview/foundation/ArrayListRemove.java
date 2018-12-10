package com.dynamic.interview.foundation;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/12/10.21:57
 * @description 当使用迭代器遍历ArrayList、Vector、LinkedList(Set集合也是)之时，如果当前遍历的是倒数第二个元素，则删除其他元素不会抛异常
 * 但是如果当前遍历的是其他就会报错，主要因为迭代器判断如果下一个元素的索引不等于集合的大小，就会返回true，否则返回false
 * 倒数第二个即将访问的元素的索引是size()-1，如果这时候查出，size()减小1，那么此时遍历提早结束，最后一个元素并不会被访问到，所以并不会报错
 */

public class ArrayListRemove {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");
        list.add("666");
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            String element = it.next();
            // 遍历倒数第二个元素的时候修改其他元素·
            if ("555".equals(element)) {
                list.remove("111");
            }
        }

    }
}
