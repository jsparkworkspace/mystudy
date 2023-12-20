package algorithm.test.baekjoon.level05.exam03;

import java.util.Scanner;

public class Main {
  Scanner sc = new Scanner(System.in);
  String[] str = new String[sc.nextInt()];

  public static void main(String args[]) {

    Main main = new Main();
    main.setString();
    main.printString();

  }

  public void setString() {
    sc.nextLine();
    for (int i = 0; i < str.length; i++) {
      str[i] = sc.nextLine();
    }
    sc.close();
  }

  public void printString() {
    for (int i = 0; i < str.length; i++) {
      int index = str[i].length();
      System.out.printf("%c%c\n", str[i].charAt(0), str[i].charAt(index - 1));
    }

  }
}
