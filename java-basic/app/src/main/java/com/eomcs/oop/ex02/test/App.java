package com.eomcs.oop.ex02.test;

import com.eomcs.oop.ex02.test.util.Calculator;

// # 관련된 기능(메서드)을 묶어 분류하기
// 1) 분류 전
// 2) 메서드를 클래스로 묶어 분류하기
// 3) 클래스 변수 도입
// 4) 클래스 변수의 한계 확인
// 5) 인스턴스 변수 도입
// 6) 인스턴스 메서드 활용
// 7) 클래스를 역할에 따라 패키지로 분류하기
// Calculator 클래스를 향후 유지보수하기 쉽도록 별도의 패키지로 분류한다.
// - com.eomcs.oop.ex02.util 패키지를 만들어 분류한다.
// - import 를 이용하여 클래스의 패키지 정보를 지정한다.

public class App {

  public static void main(String[] args) {
    // 다음 식을 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
    // 2 + 3 - 1 * 7 / 3 = ?
    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    c1.plus(2);
    c1.plus(3);
    c1.minus(1);
    c1.multiple(7);
    c1.divide(3);

    c2.plus(4);
    c2.plus(2);
    c2.minus(2);
    c2.multiple(8);
    c2.divide(4);

    System.out.printf("result = %d\n", c1.result);
    System.out.printf("result = %d\n", c2.result);
  }


}


