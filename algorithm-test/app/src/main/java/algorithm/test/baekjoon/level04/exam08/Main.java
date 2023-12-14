package algorithm.test.baekjoon.level04.exam08;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] arr = new int[42];
    int count = 0;
    for (int i = 0; i < 10; i++) {
      int n = sc.nextInt();
      arr[n % 42] = 1;
    }

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 1) {
        count += 1;
      }
    }

    System.out.println(count);
    sc.close();
  }

}
