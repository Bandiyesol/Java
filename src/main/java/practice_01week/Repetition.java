package practice_01week;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repetition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num1 = sc.nextLong();
        int num2 = 0;

        while((long)num2 < num1) {
            ++num2;
            System.out.println(num2);
        }

        Scanner sc1 = new Scanner(System.in);
        int num3 = sc1.nextInt();
        int num4 = 1;
        if (num3 == 0) {
            System.out.println(1);
        }

        while(num3 > 0) {
            num4 *= num3;
            --num3;
            if (num3 == 0) {
                System.out.println(num4);
            }
        }

        Scanner sc2 = new Scanner(System.in);
        int num5 = sc2.nextInt();

        for(int i = 0; i < num5; ++i) {
            int num6 = sc2.nextInt();
            int num7 = sc2.nextInt();
            System.out.println(num6 + num7);
        }

        Scanner sc3 = new Scanner(System.in);
        List<Integer> list = new ArrayList();
        List<Integer> list1 = new ArrayList();

        while(true) {
            int sum = sc3.nextInt();
            int sum1 = sc3.nextInt();
            if (sum == 0 && sum1 == 0) {
                for(int i = 0; i < list.size(); ++i) {
                    System.out.println((Integer)list.get(i) + (Integer)list1.get(i));
                }

                Scanner sc4 = new Scanner(System.in);
                sum1 = sc4.nextInt();

                for(int i = 1; i < 10; ++i) {
                    System.out.println(sum1 + " * " + i + " = " + sum1 * i);
                }

                Scanner sc5 = new Scanner(System.in);
                int num7 = sc5.nextInt();

                for(int i = 0; i < num7; ++i) {
                    for(int j = 0; j <= i; ++j) {
                        System.out.print("*");
                    }

                    System.out.println();
                }

                Scanner sc6 = new Scanner(System.in);

                while(sc6.hasNextInt()) {
                    int num8 = sc6.nextInt();
                    int num9 = sc6.nextInt();
                    System.out.println(num8 + num9);
                }

                sc6.close();
                return;
            }

            list.add(sum);
            list1.add(sum1);
        }
    }
}
