package algorithm.test.baekjoon.level03.exam10;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int spaceCount = n;
    int starCount = 0;

    for (int i = 0; i < n; i++) {
      spaceCount -= 1;
      starCount += 1;

      for (int j = 0; j < spaceCount; j++) {
        System.out.print(" ");
      }

      for (int k = 0; k < starCount; k++) {
        System.out.print("*");
      }
      System.out.println();
    }

    sc.close();
  }
}
