package com.eomcs.lang.ex03;

// # 리터럴(literal)
// - 자바 언어로 표현한 값.
//

public class Exam0100 {
  public static void main(String[] args) {
    System.out.println("-------- 정수 리터럴");
    System.out.println(78); // 10진수
    System.out.println(+78); // 정수 리터럴에서의 + 는 양수를 나타내는 부호로 해석되어 결과에는 출력되지 않음
    System.out.println(-78);
    System.out.println(0116); // 8진수
    System.out.println(0x4e); // 16진수
    System.out.println(0b01001110); // 2진수

    System.out.println("-------- 부동소수점 리터럴");
    System.out.println(3.14);
    System.out.println(31.4e-1);


    System.out.println("-------- 논리 리터럴");
    System.out.println(true);
    System.out.println(false);

    System.out.println("-------- 문자 리터럴");
    System.out.println('가');

    System.out.println("-------- 문자열 리터럴");
    System.out.println("오호라 코딩스쿨!");

    System.out.println("-------- 헷갈릴 수 있음");
    System.out.println("test" + 78);
    System.out.println(78 + "test");
    // 여기서 + 는 문자열과 숫자를 결합하는 연산으로 사용
    // 숫자 78이 문자열로 형변환되어 문자열 "test78", "78test"가 출력됨


  }
}
