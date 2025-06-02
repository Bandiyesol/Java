package practice_01week;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Text {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        System.out.print(ch);
        sc.close();
        Scanner sc1 = new Scanner(System.in);
        String str = sc1.next();
        System.out.println(str.length());
        sc1.close();
        Scanner sc2 = new Scanner(System.in);
        String str1 = sc2.next();

        for(int i = 0; i < str1.length(); ++i) {
            char c = str1.charAt(i);
            if (Character.isUpperCase(c)) {
                System.out.print(Character.toLowerCase(c));
            } else {
                System.out.print(Character.toUpperCase(c));
            }
        }

        sc2.close();
        Scanner sc3 = new Scanner(System.in);
        Map<String, Double> map = new HashMap();
        map.put("A+", 4.3);
        map.put("A0", (double)4.0F);
        map.put("A-", 3.7);
        map.put("B+", 3.3);
        map.put("B0", (double)3.0F);
        map.put("B-", 2.7);
        map.put("C+", 2.3);
        map.put("C0", (double)2.0F);
        map.put("C-", 1.7);
        map.put("D+", 1.3);
        map.put("D0", (double)1.0F);
        map.put("D-", 0.7);
        map.put("F", (double)0.0F);
        System.out.println(map.get(sc3.nextLine()));
        sc3.close();
        Scanner sc4 = new Scanner(System.in);
        String str2 = sc4.nextLine();
        int num = sc4.nextInt();
        char c = str2.charAt(num - 1);
        System.out.println(c);
        sc4.close();
        Scanner sc5 = new Scanner(System.in);

        while(sc5.hasNext()) {
            System.out.println(sc5.nextLine());
        }

        sc5.close();
        Scanner sc6 = new Scanner(System.in);
        int num2 = sc6.nextInt();

        for(int i = 0; i < num2; ++i) {
            String str3 = sc6.next();
            System.out.print(str3.charAt(0));
            System.out.println(str3.charAt(str3.length() - 1));
        }

        sc6.close();
    }
}
