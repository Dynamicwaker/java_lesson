package com.dynamic.threadPic.ch16.activeobject;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-22
 * @description
 */
public interface ActiveObject {
    Result<String> makeString(int count, char fillchar);

    void displayString(String string);
}
