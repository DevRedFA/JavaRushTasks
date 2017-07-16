package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/
public class Solution {

private static List<Long> longList;
    private static int[] digitsMultiSet = new int[10];
    private static long[][] power;
    private static int number;
    private static long N;
    private static long tmp;

    public static long[] getNumbers(long N) {
        Solution.N = N;
        long[] result = null;
        longList = new ArrayList<>();


        int length = 0;

        tmp = N;
        while (tmp > 0) {
            tmp /= 10;
            length++;
        }

        double h=10;
        for(int i=1; i<length; i++){
            h *=10;
        }
        if (h>Long.MAX_VALUE) h=Long.MAX_VALUE;
        Solution.N = (long)h;
        power = new long[10][length + 1];
        for (int i = 0; i < power.length; i++) {
            long p = 1;
            for (int j = 0; j < power[0].length; j++) {
                power[i][j] = p;
                p *= i;
            }
        }

        for (number = 1; number <= length; number++) {
            search(0, number, 0);
        }


        Collections.sort(longList);
        result = new long[longList.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = longList.get(i);

        return result;
    }

    private static void search(int digit, int unused, long pow) {
        if (digit == 10) {
            if (check(pow))
                longList.add(pow);
            return;
        }

        if (digit == 9) {
            digitsMultiSet[digit] = unused;
            search(digit + 1, 0, pow + unused * power[digit][number]);
        } else {
            for (int i = 0; i <= unused; i++) {
                digitsMultiSet[digit] = i;
                search(digit + 1, unused - i, pow + i * power[digit][number]);
            }
        }
    }

    private static boolean check(long pow) {
        if (Solution.N <= pow)
            return false;

        int[] testMultiSet = new int[10];

        while (pow > 0) {
            int i = (int) (pow % 10);
            testMultiSet[i]++;
            pow = pow / 10;
        }

        for (int i = 0; i < 10; i++) {
            if (testMultiSet[i] != digitsMultiSet[i])
                return false;
        }

        return true;
    }


    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        long end = System.currentTimeMillis();
        System.out.println(end - start + " millisecond");
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");

    }
}
