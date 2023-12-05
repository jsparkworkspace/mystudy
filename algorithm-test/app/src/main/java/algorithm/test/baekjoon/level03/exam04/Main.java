package algorithm.test.baekjoon.level03.exam04;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int price = sc.nextInt();
    int count = sc.nextInt();

    int[] a = new int[count];
    int[] b = new int[count];
    int total = 0;

    for (int i = 0; i < count; i++) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    for (int i = 0; i < count; i++) {
      total += a[i] * b[i];
    }
    System.out.println(total == price ? "Yes" : "No");
    sc.close();
  }

}
