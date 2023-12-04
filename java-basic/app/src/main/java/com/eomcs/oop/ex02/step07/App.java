package com.eomcs.oop.ex02.step07;

import com.eomcs.oop.ex02.step07.util.Calculator;
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

    // 다음 두 개의 식을 분리하여 계산해 보자!
    // - 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
    // 식1) 2 + 3 - 1 * 7 / 3 = ?
    // 식2) 3 * 2 + 7 / 4 - 5 = ?

    // com.eomcs.oop.ex02.step07.util.Calculator c1 = new com.eomcs.oop.ex02.step07.util.Calculator(); // 식1의 계산 결과를 보관할 메모리 준비
    // com.eomcs.oop.ex02.step07.util.Calculator c2 = new com.eomcs.oop.ex02.step07.util.Calculator(); // 식2의 계산 결과를 보관할 메모리 준비
    
    // import 명령을 사용하여 클래스의 패키지 이름을 미리 알려준다면,
    // 클래스를 지정할 때 패키지 이름을 나열할 필요가 없다.
    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    // 계산을 수행할 때 계산 결과를 보관할 메모리를 메서드 호출 앞에서 전달하라!
    // - 인스턴스 메서드를 사용하면 파라미터로 인스턴스 주소를 전달할 필요가 없다.
    c1.plus(2); // + 2
    c2.plus(3); // + 3

    c1.plus(3); // + 2 + 3
    c2.multiple(2); // + 3 * 2

    c1.minus(1); // + 2 + 3 - 1
    c2.plus(7); // + 3 * 2 + 7

    c1.multiple(7); // + 2 + 3 - 1 * 7
    c2.divide(4); // + 3 * 2 + 7 / 4

    c1.divide(3); // + 2 + 3 - 1 * 7 / 3 = ?
    c2.minus(5); // + 3 * 2 + 7 / 4 - 5 = ?

    // result 변수가 어떤 인스턴스에 있는 변수인지 지정해야 한다.
    System.out.printf("c1.result = %d\n", c1.result);
    // 식2의 계산 결과는 c2 인스턴스의 result 변수에 들어 있다.
    System.out.printf("c2.result = %d\n", c2.result);


    // 각각의 계산식 결과는 서로 다른 result 변수에 보관되기 때문에 새로 초기화 할 필요가 없다.
    // c2.result 0;
  }
}

