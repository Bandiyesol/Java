package practice_01week;

import java.util.Scanner;

public class Condition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        if (num1 > num2) {
            System.out.println(">");
        } else if (num1 < num2) {
            System.out.println("<");
        } else {
            System.out.println("==");
        }

        Scanner sc1 = new Scanner(System.in);
        int num3 = sc1.nextInt();
        if (num3 <= 100 && num3 >= 90) {
            System.out.println('A');
        } else if (num3 < 90 && num3 >= 80) {
            System.out.println('B');
        } else if (num3 < 80 && num3 >= 70) {
            System.out.println('C');
        } else if (num3 < 70 && num3 >= 60) {
            System.out.println('D');
        } else {
            System.out.println('F');
            System.out.println('F');
        }

        Scanner sc2 = new Scanner(System.in);
        int num4 = sc2.nextInt();
        int num5 = sc2.nextInt();
        if (num4 > 0 && num5 > 0) {
            System.out.println(1);
        } else if (num4 < 0 && num5 > 0) {
            System.out.println(2);
        } else if (num4 < 0 && num5 < 0) {
            System.out.println(3);
        } else if (num4 > 0 && num5 < 0) {
            System.out.println(4);
        }

        Scanner sc3 = new Scanner(System.in);
        int num6 = sc3.nextInt();
        if ((num6 % 4 != 0 || num6 % 100 == 0) && num6 % 400 != 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }

        Scanner sc4 = new Scanner(System.in);
        long num7 = sc4.nextLong();
        long num8 = sc4.nextLong();
        System.out.println(Math.abs(num7 - num8));
    }
}