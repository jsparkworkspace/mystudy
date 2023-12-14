// Integer 클래스: new Integer() vs Integer.valueOf()
package com.eomcs.oop.ex04;

public class Exam0221 {
  public static void main(String[] args) throws Exception {
    Integer obj1 = new Integer(100);
    Integer obj2 = new Integer(100);
    Integer obj3 = new Integer(100);

    Integer i1 = Integer.valueOf(125);
    Integer i2 = Integer.valueOf(126);
    Integer i3 = Integer.valueOf(127);
    Integer i4 = Integer.valueOf(127);
    // 1) 생성자를 통해 객체를 만들면 무조건 새 객체를 만든다.
    System.out.println(obj1 == obj2);
    System.out.println(obj1 == obj3);
    System.out.println(obj2 == obj3);
    System.out.println("---------------------------");

    // 2) valueOf()를 통해 객체를 만들면 자주 쓰는 값(-128 ~ +127)에 대해서는 한 번만 만들어 공유한다.
    // 한 객체가 (-128 ~ +127) 범위를 공유하는 것이 아니고 같은 값을 가진 객체를 다시 생성하려고 할 때 공유된다는 말
    // (-128 ~ +127)범위의 값은 객체 생성 시 캐싱하여 저장하고 있다가
    // 같은 값을 가진 객체를 생성하려고하면 캐싱된 객체를 반환한다. 즉 재사용 한다는 말
    System.out.println(i1 == i2);
    System.out.println(i1 == i3);
    System.out.println(i2 == i3);
    System.out.println(i3 == i4);
  }
}


