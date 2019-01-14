package com.itrjp;/**
 * Created by renjp on 2018/12/17.
 */

/**
 * @author renjp
 * @Date 2018/12/17 9:42
 * @Version 1.0
 */
public class LambdaTest {
    String name = "lambdaTest";

    public static void main(String[] args) {
        new LambdaTest().test();
    }

    public void test() {
        new Thread(new Runnable() {
            String name = "runnable";

            @Override
            public void run() {
                System.out.println(this.name);
            }
        }).start();
        new Thread(() ->
                        System.out.println(this.name)
        ).start();
        new Thread(() ->
                System.out.println("aaa")
        ).start();
    }
}
