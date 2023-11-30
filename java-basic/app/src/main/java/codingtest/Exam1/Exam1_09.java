package codingtest.Exam1;

import java.util.Scanner;

public class Exam1_09 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

    System.out.println((a + b) % c);
    System.out.println(((a % c) + (b % c)) % c);
    System.out.println((a * b) % c);
    System.out.println(((a % c) * (b % c)) % c);

  }

}
