package algorithm.test.baekjoon.level05.exam05;

import java.util.Scanner;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    String str = sc.next();
    int result = 0;
    for (int i = 0; i < a; i++) {
      result = result + (str.charAt(i) - '0');
    }
    System.out.println(result);
    sc.close();
  }
}
