package com.javarush.task.task20.task2025;

import java.util.*;

/**
 * Created by Ivan on 01.05.2017.
 */
public class Solution2 {


    private static List<Long> list = new LinkedList<>();
    private static long[][] powers;
    private static long Number;
    private static long sum;
    private static byte[] bytes;
    public static long[] getNumbers(long N) {

        int num = (int) Math.log10(N) + 1;
        powers = new long[10][num];
        for (int i = 1; i < powers.length; i++) {
            for (int j = 0; j < num; j++) {
                powers[i][j] = (long) Math.pow(i, j + 1);
            }
        }
        int[] full = new int[num];


        st:
        for (long i = 1; i < N; i++) {

            Number = i;

//            bytes = String.valueOf(i).getBytes();
//
//            for (int j=0; j<bytes.length; j++){
//                full[j] = (int)bytes[j]-48;
//            }
            num = (int) Math.log10(i) + 1;
            for (int j = 0; j < num; j++) {
                full[j] = (int) Number % 10;
                Number /= 10;
            }


            sum = 0l;
                for (int n = 0; n < num; n++) {
                sum += powers[full[n]][num - 1];
                if (sum > i) continue st;
            }
            if (i == sum) list.add(i);
        }


        long[] array = new long[list.size()];
        for (
                int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(146511208)));
        long end = System.currentTimeMillis();
        System.out.println(end - start + " millisecond");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");

    }
}
