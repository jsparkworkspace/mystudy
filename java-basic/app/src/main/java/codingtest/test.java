package codingtest;

import java.util.Scanner;

public class test {

  public static void main(String[] args) {
    System.out.println("Hello World!");

    System.out.println("정수 2개를 입력하세요");
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    // 사칙연산 순서로 인해 앞에 문자열 때문에 문자열의 + 가 되어버리니 ()로 묶어서 정수 연산을 하게 만듬
    // System.out.println("더하기 : " + (a + b));
    System.out.println("더하기 : " + add(a, b));
    // System.out.println("빼기 : " + (a - b));
    System.out.println("빼기 : " + sub(a, b));
    // System.out.println("곱하기 : " + a * b);
    System.out.println("곱하기 : " + mul(a, b));

    System.out.println("부동소수점 2개를 입력하세요");
    double c = sc.nextDouble();
    double d = sc.nextDouble();
    // System.out.println(c / d);
    System.out.println("나누기 : " + div(c, d));

    System.out.println("문자(유니코드 10진수 값)를 입력하세요(next() 메서드 종류에 리턴 값이 char 형은 없음..)");
    char ch = (char) sc.nextInt();
    System.out.println(ch);

    System.out.println("문자열을 입력하세요");
    sc.nextLine(); // 남아 있는 빈 문자열의 한 줄(LF 코드)을 읽어서 버린다.
    String str = sc.nextLine();
    System.out.println(str);

    sc.close();

  }

  public static int add(int a, int b) {

    return a + b;

  }

  public static int sub(int a, int b) {

    return a - b;
  }

  public static int mul(int a, int b) {
    return a * b;
  }

  public static double div(double a, double b) {
    return a / b;

  }
}
