package com.dynamic.interview.proxy.demotwo;

/**
 * @author xinghuajian
 * @description 目标类
 * @date 2019/10/21 13:54
 */
public class Person {
    private Long pid;
    private String name;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
