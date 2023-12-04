package codingtest.Exam2;

import java.util.Scanner;

public class Exam2_06 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int h = sc.nextInt();
    int m = sc.nextInt();
    int usingTime = sc.nextInt();
    int addTime = 0;

    addTime = m + usingTime;

    if (addTime >= 60) {
      h = h + addTime / 60;
      m = addTime % 60;

      if (h >= 24) {
        h = h - 24;
      }
    } else {
      m = addTime;
      if (h >= 24) {
        h = h - 24;
      }
    }

    System.out.println(h + " " + m);

  }

}
