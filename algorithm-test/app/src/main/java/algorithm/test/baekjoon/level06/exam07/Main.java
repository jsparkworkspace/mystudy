package algorithm.test.baekjoon.level06.exam07;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    for (int i = 0; i < n; i++) {
      String str = sc.next();

      for (int j = 0; j < str.length() - 1; j++) {

        if (str.charAt(j) == str.charAt(j + 1)) {
          String str2 = str.replaceAll(str.charAt(j) + str.charAt(j + 1), str.j);
        }

      }

    }

  }
}
