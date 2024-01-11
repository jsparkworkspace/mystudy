package algorithm.test.baekjoon.level05.exam09;

import java.util.Scanner;

public class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();

    String[] data = str.split(" ");
    int wordCount = 0;
    int[] num;
    // int k = 0;

    if (data[0].equals("")) {
      wordCount = data.length - 1;
      num = new int[wordCount];
      // k++;
    } else {
      wordCount = data.length;
      num = new int[wordCount];
    }

    for (int i = 0; i < data.length; i++) {
      // if (data[i].equals("")) {
      // continue;
      // }
      String temp = "";
      for (int j = data[i].length() - 1; j >= 0; j--) {
        temp += data[i].charAt(j);
      }
      // System.out.println(temp);
      num[i] = Integer.valueOf(temp);
      // System.out.println(num[i]);
    }

    if (num[0] > num[1]) {
      System.out.println(num[0]);
    } else {
      System.out.println(num[1]);
    }

    sc.close();

  }
}
