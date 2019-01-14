package com.itrjp;/**
 * Created by renjp on 2018/12/17.
 */

/**
 * @author renjp
 * @Date 2018/12/17 10:18
 * @Version 1.0
 */
public class DemoClass1 {

    public static void main(String[] args) {
        DemoClass1 class1 = new DemoClass1();
        System.out.println(class1.test(6));
    }

    public int test(DemoClass1 this, int x) {
        System.out.println(this);
        return x * 2;
    }
}
