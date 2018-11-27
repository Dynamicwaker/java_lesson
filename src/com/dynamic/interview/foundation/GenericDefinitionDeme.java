package com.dynamic.interview.foundation;

/**
 * @author <a herf="mailto:xinghj0308@gmail.cn">xinghuajian</a>
 * @version Created on 2018/11/27.23:06
 * @description 泛型
 * 1、<>括号中都代表了一种未知类型
 * 2、<>位置必须在类型之后或者方法返回值之前
 * 3、泛型在定义处只具备Object方法的能力，比如下面的get()内部的string没有string.longValue()，alibaba没有alibaba.intValue()方法等
 * 4、对于编译之后的字节码指令，没有这些花头花脑的方法签名，说明泛型只是一种编写代码时的语法检查
 * --类型擦除 编译后get方法的参数是两个Object，返回值也是Object。
 * 类型安全、提高可读性，代码复用
 */

public class GenericDefinitionDeme<T> {
    static <String, T, Alibaba> String get(String string, Alibaba alibaba) {
        return string;
    }

    public static void main(String[] args) {
        Integer first = 222;
        Long second = 333L;
        Integer result = get(first, second);
        System.out.println(result);
    }
}
