package algorithm.test.baekjoon.level04.exam04;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] num = new int[9];
    int count = 0;
    int max = 0;
    for (int i = 0; i < num.length; i++) {
      num[i] = sc.nextInt();
    }

    for (int i = 0; i < num.length; i++) {
      if (max < num[i]) {
        max = num[i];
        count = i + 1;
      }
    }
    System.out.println(max);
    System.out.println(count);
    sc.close();
  }

}
