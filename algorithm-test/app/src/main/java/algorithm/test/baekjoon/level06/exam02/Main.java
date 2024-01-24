package algorithm.test.baekjoon.level06.exam02;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] arr = new int[6];
    int[] arrnum = {1, 1, 2, 2, 2, 8};

    for (int i = 0; i < arr.length; i++) {
      arr[i] = sc.nextInt();

      if (arr[i] == arrnum[i]) {
        System.out.print(0 + " ");
      } else {
        System.out.print(arrnum[i] - arr[i] + " ");
      }

    }

  }
}
