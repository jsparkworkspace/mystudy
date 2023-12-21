package algorithm.test;

import java.util.Scanner;

public class Calculator {
  int result = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();

    Calculator cal = new Calculator();
    cal.add(a, b);
    cal.sub(a, b);
    cal.multiple(a, b);
    cal.devide(a, b);
    sc.close();
  }

  public void add(int a, int b) {
    result = a + b;
    System.out.println(result);
  }

  public void sub(int a, int b) {
    result = a - b;
    System.out.println(result);
  }

  public void multiple(int a, int b) {
    result = a * b;
    System.out.println(result);
  }

  public void devide(int a, int b) {
    result = a / b;
    System.out.println(result);
  }
}
