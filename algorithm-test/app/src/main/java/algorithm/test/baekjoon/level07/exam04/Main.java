package algorithm.test.baekjoon.level07.exam04;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[][] arr = new int[100][100];

    int n = sc.nextInt();

    for (int i = 0; i < n; i++) {
      int r = sc.nextInt();
      int c = sc.nextInt();

      for (int j = 0; j < 10; j++) {
        for (int k = 0; k < 10; k++) {
          arr[100 - r - j][c + k]++;
        }
      }
    }
    int cnt = 0;
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        if (arr[i][j] > 0)
          cnt++;
      }
    }
    System.out.print(cnt);

    sc.close();
  }

}
