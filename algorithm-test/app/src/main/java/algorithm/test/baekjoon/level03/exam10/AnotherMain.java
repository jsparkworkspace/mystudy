package algorithm.test.baekjoon.level03.exam10;

import java.util.Scanner;

public class AnotherMain {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    for (int i = n; i > 0; i--) {

      for (int j = 0; j < n; j++) {
        if (i - 1 > j) {
          System.out.print(" ");
        } else {
          System.out.print("*");
        }
      }
      System.out.println();
    }

  }

}
