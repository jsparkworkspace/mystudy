package algorithm.test.baekjoon.level08.exam02;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int b = sc.nextInt();

    System.out.print(Integer.toString(n, b).toUpperCase());

    sc.close();

  }

}
