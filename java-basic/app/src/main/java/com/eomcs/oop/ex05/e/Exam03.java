// 상속과 메서드 호출
package com.eomcs.oop.ex05.e;

public class Exam03 {

  public static void main(String[] args) {
    B obj = new D();
    // obj 레퍼런스는 B클래스의 레퍼런스
    // 이때 obj는 다형적 변수 : 서브 클래스의 인스턴스 주소도 저장할 수 있다.
    // D클래스의 인스턴스로 생성되었지만 변수 타입이 B클래스라서 수퍼클래스인 A 클래스의 정보만 찾을 수 있다.

    // obj.m4(); // obj 레퍼런스의 클래스(B)에서 m4()를 찾아보고 없다면 수퍼 클래스에서 찾는다.
    // obj.m3(); // obj 레퍼런스의 클래스(B)에서 m3()를 찾아보고 없다면 수퍼 클래스에서 찾는다.
    obj.m2();
    obj.m1();

  }

}
