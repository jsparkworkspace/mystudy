package algorithm.test.baekjoon.level07.exam03;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    char[][] arr = new char[5][15];

    for (int i = 0; i < 5; i++) {
      String str = sc.next();

      for (int j = 0; j < str.length(); j++) {
        arr[i][j] = str.charAt(j);
      }
    }

    for (int j = 0; j < 15; j++) {
      for (int i = 0; i < 5; i++) {
        if (arr[i][j] == '\0')
          continue;
        System.out.printf("%c", arr[i][j]);
      }
    }

    sc.close();
  }

}
