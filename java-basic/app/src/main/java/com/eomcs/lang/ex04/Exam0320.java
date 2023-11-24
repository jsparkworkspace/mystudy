package com.eomcs.lang.ex04;

// # 변수 사용 II
// - 다른 변수에 값을 저장할 때 사용할 수 있다.
//

public class Exam0320 {
  public static void main(String[] args) {

    int age1 = 20;

    // r-value 자리에 변수를 놓을 수 있다.
    int age2 = age1;

    // l-value, r-value '='을 기준으로 왼쪽, 오른쪽으로 나눈 값
    // l-value : 변수만 사용가능
    // r-value : 변수, 리터럴, 표현식(expressim = 값을 표현하는 statement)
    // 표현식 종류 예) b = Math.abs(-20)
    age2 = age1;

    // 의미
    // - age1에 저장된 값을 age2에 복사하라!

    // age1과 age2는 같은 메모리가 아니다.
    // 증명
    // - age1의 값을 변경한다.
    age1 = 30;

    System.out.println(age1);
    System.out.println(age2);
  }
}
