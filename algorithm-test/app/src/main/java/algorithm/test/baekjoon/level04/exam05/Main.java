package algorithm.test.baekjoon.level04.exam05;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt(), m = sc.nextInt();
    int i, j, k;


    int[] arr = new int[n];

    for (int f = 0; f < m; f++) {
      i = sc.nextInt();
      j = sc.nextInt();
      k = sc.nextInt();

      for (int g = i - 1; g < j - 1; g++) {
        arr[g] = k;
      }

    }
    for (int f = 0; f < n; f++) {
      System.out.print(arr[f]);
    }
    sc.close();
  }

}
