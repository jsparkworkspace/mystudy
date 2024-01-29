package algorithm.test.baekjoon.level06.exam06;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    String[] c = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    for (int i = 0; i < c.length; i++) {
      if (str.contains(c[i])) {
        str = str.replace(c[i], "@");
      }
    }
    System.out.println(str.length());
    sc.close();
  }
}
