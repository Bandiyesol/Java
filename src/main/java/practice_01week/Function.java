package practice_01week;

import java.util.Scanner;

public class Function {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        int sum = 0;

        for(int i = 0; i < 5; ++i) {
            sum = (int)((double)sum + Math.pow((double)sc1.nextInt(), (double)2.0F));
        }

        System.out.println(sum % 10);
    }
}
