package com.itrjp;/**
 * Created by renjp on 2018/12/17.
 */

import java.util.function.IntUnaryOperator;

/**
 * @author renjp
 * @Date 2018/12/17 10:06
 * @Version 1.0
 */
public class DemoClass {
    public static int staticMethod(int i){
        return i * 2;
    }
    public int method(int i){
        System.out.println("实例方法可以访问this:" + this);
        return i*2;
    }

    public static void main(String[] args) {
        IntUnaryOperator staticMethod = DemoClass::staticMethod;
        System.out.println(staticMethod.applyAsInt(2));

        DemoClass demoClass = new DemoClass();
        IntUnaryOperator method = demoClass::method;
        System.out.println(method.applyAsInt(3));
    }
}
