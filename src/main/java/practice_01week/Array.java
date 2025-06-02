package practice_01week;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; ++i) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < N; ++i) {
            if (arr[i] < M) {
                System.out.print(arr[i] + " ");
            }
        }

        sc.close();
        Scanner sc1 = new Scanner(System.in);
        int N1 = sc1.nextInt();
        int[] arr1 = new int[N1];

        for(int i = 0; i < N1; ++i) {
            int N2 = sc1.nextInt();
            arr1[i] = N2;
        }

        int N3 = sc1.nextInt();
        int N4 = 0;

        for(int i = 0; i < N1; ++i) {
            if (arr1[i] == N3) {
                ++N4;
            }
        }

        sc1.close();
        System.out.println(N4);
        Scanner sc2 = new Scanner(System.in);
        int[] arr2 = new int[30];

        for(int i = 0; i < 28; ++i) {
            int N5 = sc2.nextInt();
            arr2[N5 - 1] = 1;
        }

        for(int i = 0; i < arr2.length; ++i) {
            if (arr2[i] != 1) {
                System.out.println(i + 1);
            }
        }

        sc2.close();
        Scanner sc3 = new Scanner(System.in);
        int N6 = sc3.nextInt();
        int N7 = sc3.nextInt();
        int[][] arr3 = new int[N6][N7];
        int[][] arr4 = new int[N6][N7];
        int[][] arr5 = new int[N6][N7];

        for(int i = 0; i < N6; ++i) {
            for(int j = 0; j < N7; ++j) {
                arr3[i][j] = sc3.nextInt();
            }
        }

        for(int i = 0; i < N6; ++i) {
            for(int j = 0; j < N7; ++j) {
                arr4[i][j] = sc3.nextInt();
            }
        }

        for(int i = 0; i < N6; ++i) {
            for(int j = 0; j < N7; ++j) {
                arr5[i][j] = arr3[i][j] + arr4[i][j];
            }
        }

        for(int i = 0; i < N6; ++i) {
            for(int j = 0; j < N7; ++j) {
                System.out.print(arr5[i][j] + " ");
            }
        }

        sc3.close();
    }
}