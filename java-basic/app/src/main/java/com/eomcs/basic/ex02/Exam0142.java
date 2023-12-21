// String - 다형적 변수와 형변환
package com.eomcs.basic.ex02;

public class Exam0142 {
  public static void main(String[] args) {

    Object obj = new String("Hello");

    // obj가 String 객체를 가리키더라도
    // obj의 타입이 Object이기 때문에 Object에 선언한 멤버만 사용할 수 있다.
    // obj가 가리키는 원래 클래스의 메서드를 호출하고 싶다면
    // 다음과 같이 원래 타입으로 형변환하라.
    // 형변환 하지않으면 컴파일 단계에서 에러가 발생한다.
    // => obj의 인스턴스는 String 클래스이기 때문에 실행에는 문제 없으나
    // => 컴파일러는 obj의 타입인 Object 클래스에서 toLowerCase()를 찾는데 메서드가 없어서 에러 발생
    String str = ((String) obj).toLowerCase();
    System.out.println(str);

    // String 객체는 immutable(변경할 수 없는) 객체이다.
    System.out.println(obj == str);
    System.out.println(obj);

    // 또는 다음과 같이 원래 타입의 레퍼런스에 저장한 다음 사용하라.
    String x1 = (String) obj;
    str = x1.toLowerCase();
    System.out.println(str);
  }
}


