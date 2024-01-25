package algorithm.test.baekjoon.level06.exam04;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    char[] arr = new char[str.length()];
    boolean b = true;

    for (int i = 0; i < arr.length; i++) {
      arr[i] = str.charAt(i);
      // System.out.print(arr[i] + " ");

    }
    // System.out.print(arr.length);

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != arr[arr.length - i - 1]) {
        b = false;
      }
    }

    if (b == false) {
      System.out.print(0);
    } else {
      System.out.print(1);
    }

    sc.close();
  }

}
