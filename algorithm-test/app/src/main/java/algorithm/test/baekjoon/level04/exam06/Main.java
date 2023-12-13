package algorithm.test.baekjoon.level04.exam06;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = i + 1;
    }

    for (int k = 0; k < m; k++) {
      int i = sc.nextInt();
      int j = sc.nextInt();

      int temp = arr[i - 1];
      arr[i - 1] = arr[j - 1];
      arr[j - 1] = temp;

    }

    for (int k = 0; k < n; k++) {
      System.out.print(arr[k] + " ");
    }
  }

}
