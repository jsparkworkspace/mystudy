package algorithm.test;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.
    Scanner sc = new Scanner(System.in);
    String str = sc.next();

    while (true) {
      if (str.length() == 1) {
        break;
      }

      int n = sc.nextInt();

      if (n >= str.length() - 1) {
        str = str.substring(0, str.length() - 1);
      } else if (n == 0) {
        str = str.substring(1);
      } else {
        str = str.substring(0, n) + str.substring(n + 1);
      }
      System.out.println(str);

    }


    sc.close();
  }
}
