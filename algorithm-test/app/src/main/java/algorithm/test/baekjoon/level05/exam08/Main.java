package algorithm.test.baekjoon.level05.exam08;

import java.util.Scanner;

public class Main {

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();

    String[] data = str.split(" ");

    int wordLangth = data.length;

    for (int i = 0; i < data.length; i++) {
      if (data[i] == "") {
        wordLangth--;
      }

    }

    System.out.println(wordLangth);
    sc.close();

  }
}
