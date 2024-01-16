package algorithm.test;

import java.util.Scanner;

public class DateTest {

  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.

    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();

    int value, remain;

    value = a / b;
    remain = a % b;

    System.out.print(value);
    System.out.print(".");

    for (int i = 0; i < 20; i++) {

      remain *= 10;
      value = remain / b;
      remain = remain % b;
      System.out.print(value);

    }

  }

}
