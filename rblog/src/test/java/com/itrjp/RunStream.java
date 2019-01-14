package com.itrjp;/**
 * Created by renjp on 2018/12/17.
 */

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @author renjp
 * @Date 2018/12/17 10:50
 * @Version 1.0
 */
public class RunStream {

    public static void main(String[] args) {
        Random random = new Random();
        Stream<Integer> stream = Stream
                .generate(() ->
                        random.nextInt())
                .limit(5)
                .peek(x -> print("peek " + x))
                .filter(x -> {
                    print("filter" + x);
                    return x > 10000;
                })
                .sorted((x1, x2) -> {
                    print("sorted" + x1 + " " + x2);
                    return x1.compareTo(x2);
                })
                .peek(x -> {
                    print("peek2" + x);
                }).parallel();
        long count = stream.count();
        System.out.println(count);


    }

    /**
     * 打印日志并sleep 5 毫秒
     *
     * @param s
     */
    public static void print(String s) {
        // System.out.println(s);
        // 带线程名(测试并行情况)
        System.out.println(Thread.currentThread().getName() + " > " + s);
        try {
            TimeUnit.MILLISECONDS.sleep(5);
        } catch (InterruptedException e) {
        }
    }
}
