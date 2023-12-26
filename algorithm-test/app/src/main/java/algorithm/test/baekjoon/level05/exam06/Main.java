package algorithm.test.baekjoon.level05.exam06;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String word = sc.next();
    String abc = "abcdefghijklmnopqrstuvwxyz";
    int[] index = new int[26];
    Arrays.fill(index, -1);

    for (char c : word.toCharArray()) {
      index[abc.indexOf(c)] = word.indexOf(c);
    }

    for (int i = 0; i < index.length; i++) {
      System.out.print(index[i] + " ");
    }
  }
}
