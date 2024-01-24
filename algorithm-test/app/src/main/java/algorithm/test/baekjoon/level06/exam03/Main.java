package algorithm.test.baekjoon.level06.exam03;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int cnt = 1;

    for (int i = 0; i < 2 * n - 1; i++) {
      if (i < n) {
        for (int j = 0; j < n + i; j++) {
          if (j < n - (i + 1)) {
            System.out.print(" ");
          } else {
            System.out.print("*");
          }
        }

      } else {
        for (int j = 0; j < (2 * n - 1) - cnt; j++) {
          if (j < cnt) {
            System.out.print(" ");
          } else {
            System.out.print("*");
          }
        }
        cnt++;
      }
      System.out.println();
    }
    sc.close();
  }

}
