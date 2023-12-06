package algorithm.test.baekjoon.level03.exam08;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    int[] a = new int[t];
    int[] b = new int[t];
    int[] sum = new int[t];

    for (int i = 0; i < t; i++) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
      sum[i] = a[i] + b[i];
    }

    for (int i = 0; i < t; i++) {
      System.out.printf("Case #%d: %d + %d = %d\n", i + 1, a[i], b[i], sum[i]);
    }

  }

}
