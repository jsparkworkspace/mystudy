package algorithm.test.baekjoon.level07.exam02;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[][] arr = new int[9][9];
    int max = 0;
    int r = 1;
    int c = 1;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = sc.nextInt();
      }
    }

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (max < arr[i][j]) {
          max = arr[i][j];
          r = i + 1;
          c = j + 1;
        }

      }
    }

    System.out.println(max);
    System.out.printf("%d %d", r, c);

    sc.close();
  }

}
