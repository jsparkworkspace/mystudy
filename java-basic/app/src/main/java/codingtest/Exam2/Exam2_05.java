package codingtest.Exam2;

import java.util.Scanner;

public class Exam2_05 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int h = sc.nextInt(), m = sc.nextInt();

    if (m >= 45) {
      m -= 45;
    } else {
      m = 60 + m - 45;
      if (h == 0)
        h = 24 - 1;
      else
        h -= 1;
    }

    System.out.println(h + " " + m);

    sc.close();
  }

}
