package LeetCode.M0001;

import java.util.ArrayList;
import java.util.List;

// n重循环的递归写法
/*
 * 设有字母 abc 输出由这些字母组成的字符串的所有可能 字符串的长度为n
 * 例如 n 为 2  输出 aa  ab  ac  ba  bb  bc  ca  cb  cc  9
 * */

public class M0001 {

    private static int n = 2;

    private static int count;
    private static List<Integer> array = new ArrayList<>();
    private static char[] str = {'a', 'b', 'c'};

    public static void main(String[] args) {
        func(1);
        System.out.println(count);
    }

    private static void func(int cen) {
        if (cen == n + 1) {
            for (Integer i : array) {
                System.out.print(str[i]);
            }
            System.out.print("  ");
            count++;
            array.remove(array.size() - 1);
            return;
        }
        for (int i = 0; i < str.length; i++) {
            array.add(i);
            func(cen + 1);
        }

        if (!array.isEmpty()) {
            array.remove(array.size() - 1);
        }
    }
}
