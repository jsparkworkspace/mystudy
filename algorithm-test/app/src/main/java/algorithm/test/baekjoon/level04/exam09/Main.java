package algorithm.test.baekjoon.level04.exam09;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] n = new int[sc.nextInt()];
    int m = sc.nextInt();

    for (int i = 0; i < n.length; i++) {
      n[i] = i + 1;
    }

    for (int i = 0; i < m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();

      for (int j = a - 1; j < b - 1; j++) {
        int index = --b;

        int temp = n[j];
        n[j] = n[index];
        n[index] = temp;

      }


    }
    for (int i = 0; i < n.length; i++) {
      System.out.print(n[i] + " ");
    }

  }

}
