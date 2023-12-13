package algorithm.test.baekjoon.level04.exam08;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] arr = new int[10];
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt() % 42;
    }

    for (int i = 0; i < arr.length - 1; i++) {

      for (int j = i + 1; j < arr.length - 1; j++) {
        if (arr[i] == arr[j]) {

        }
      }
    }
  }

}
