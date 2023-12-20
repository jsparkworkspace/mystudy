package algorithm.test.baekjoon.level05.exam01;

import java.util.Scanner;

public class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String word = sc.nextLine();
    int index = sc.nextInt();

    System.out.println(word.charAt(index - 1));
  }
}
