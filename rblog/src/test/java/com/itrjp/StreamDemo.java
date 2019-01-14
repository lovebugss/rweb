package com.itrjp;/**
 * Created by renjp on 2018/12/17.
 */

import java.util.stream.IntStream;

/**
 * @author renjp
 * @Date 2018/12/17 10:34
 * @Version 1.0
 */
public class StreamDemo {

    public static void main(String[] args) {
        int[] nums = {3,4,5,6,7,8};

        int sum = IntStream.of(nums).map(StreamDemo::doubleNum).sum();
        System.out.println(sum);

        System.out.println("11111111111111");
        IntStream.of(nums).map(StreamDemo::doubleNum);


    }
    public static int doubleNum(int i){
        System.out.println("doubleNum");
        return i * 2;

    }
}
