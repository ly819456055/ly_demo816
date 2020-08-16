package com.practice.practice.test;

import java.util.Scanner;

public class Test2 {
        public static void main(String[] args) {
            System.out.println("输入月份：");
            Scanner sc = new Scanner(System.in);
            int one = sc.nextInt();
            if (one <= 0) {
                System.out.println("输出错误，");
            } else {
                System.out.println("兔子的对数为：" + rabit(one));
            }

    }

    public static int rabit(Integer one) {
        double a = 1;
        int b = one / 3;
        if (b < 1) {
            double c = 1;
            System.out.println("兔子的对数为：" + (int) c);
            return (int) c;
        } else {
            a = 2;
            double c = Math.pow(a, (double) b);
            System.out.println("兔子的对数为：" + (int) c);
            return (int) c;
        }
    }

}
