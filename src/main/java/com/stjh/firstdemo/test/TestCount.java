package com.stjh.firstdemo.test;

import java.util.Arrays;

/**
 * @Author: wuge
 * @Date: 2021-2-4
 */
public class TestCount {

    private static int[] arr = {1, 0, 2, 4, 2};

    public static void main(String[] args) {
        //System.out.println(maxCount());;

    }

    private static int maxCount() {
        int[] arr1 = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr1[arr[i]] += 1;
        }
        System.out.println(Arrays.toString(arr1));
        int maxCount = 0;
        for (int i = 1; i < arr1.length; i++) {
            if (arr1[i] > arr1[maxCount]) {
                maxCount = i;
            }
        }
        return maxCount;
    }
}
