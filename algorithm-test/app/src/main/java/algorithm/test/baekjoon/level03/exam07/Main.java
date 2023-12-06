package algorithm.test.baekjoon.level03.exam07;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    int[] sum = new int[t];

    for (int i = 0; i < t; i++) {
      int a = sc.nextInt(), b = sc.nextInt();
      sum[i] = a + b;
    }

    for (int i = 0; i < t; i++) {
      System.out.printf("Case #%d: %d\n", i + 1, sum[i]);
    }
    sc.close();
  }

}
