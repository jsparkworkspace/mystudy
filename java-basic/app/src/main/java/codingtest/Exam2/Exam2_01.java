package codingtest.Exam2;

import java.util.Scanner;

public class Exam2_01 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt(), b = sc.nextInt();

    sc.close();

    if (a > b) {
      System.out.println(">");
    } else if (a < b) {
      System.out.println("<");
    } else {
      System.out.println("==");
    }

  }

}
