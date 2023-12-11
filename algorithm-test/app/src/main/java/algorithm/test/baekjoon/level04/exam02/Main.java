package algorithm.test.baekjoon.level04.exam02;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] n = new int[sc.nextInt()];
    int x = sc.nextInt();

    for (int i = 0; i < n.length; i++) {
      n[i] = sc.nextInt();
    }

    for (int i = 0; i < n.length; i++) {
      if (n[i] < x) {
        System.out.printf("%s ", n[i]);
      }
    }
    sc.close();
    System.out.println();

  }

}
