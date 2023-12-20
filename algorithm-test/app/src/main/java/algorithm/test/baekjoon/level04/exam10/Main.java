package algorithm.test.baekjoon.level04.exam10;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double sum = 0;
    double average = 0;
    int n = sc.nextInt();
    int[] m = new int[n];
    for (int i = 0; i < n; i++) {
      m[i] = sc.nextInt();
    }

    Arrays.sort(m);

    for (int i = 0; i < m.length; i++) {
      sum = sum + m[i];
    }

    average = (sum / m[m.length - 1]) * 100 / m.length;

    System.out.println(average);
    sc.close();
  }

}
