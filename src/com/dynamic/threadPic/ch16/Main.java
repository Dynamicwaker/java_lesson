package com.dynamic.threadPic.ch16;

import com.dynamic.threadPic.ch16.activeobject.ActiveObject;
import com.dynamic.threadPic.ch16.activeobject.ActiveObjectFactory;

/**
 * @author <a href="mailto:xinghuajian@gtmap.cn">xinghuajian</a>
 * @version 1.0, 2018-10-22
 * @description Active Object模式，接受异步消息的主动对象
 */
public class Main {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new MakerClientThread("Alice", activeObject).start();
        new MakerClientThread("Bobby", activeObject).start();
        new DisplayClientThread("Chris", activeObject).start();
    }
}
