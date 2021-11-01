package com.dynamic.interview.reflect;

import java.lang.reflect.Field;

/**
 * @author:xinghj0308@gmail.com
 * @create:2021/5/29
 * @description:
 */
public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> clazz) {
        String strFruitProvider = "供应商信息：";

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if(field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                strFruitProvider = "供应商编号：" + fruitProvider.id() + "，供应商名称：" + fruitProvider.name()
                        + "，供应商地址：" + fruitProvider.address();
                System.out.println(strFruitProvider);
            }
        }

    }
}
