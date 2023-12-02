package codingtest;

import java.util.Scanner;

public class test {

  static int sum(int vaule) {
    if (vaule == 1) {
      return 1;
    } // if end
    return vaule + sum(vaule - 1);
  } // sum method end

  static int prompt() {
    System.out.print("어느 숫자까지 더할지 목표 값을 입력해주세요 : ");
    Scanner sc = new Scanner(System.in);
    int vaule = sc.nextInt();
    sc.close();

    return vaule;
  } // prompt method end

  public static void main(String[] args) {
    System.out.println(sum(prompt()));
  } // main method end

} // class test end
