package com.eomcs.reflect.ex06.a;

import java.lang.reflect.Proxy;

public class Exam0121 {
  public static void main(String[] args) {


    Object obj = Proxy.newProxyInstance(
        Exam0121.class.getClassLoader(),
        new Class<?>[] {A.class, B.class, C.class}, 
        (proxy, method, params) -> {
          System.out.println("===>" + method.getName());
          return null;
        });

    ((A) obj).m1();
    ((B) obj).m2();
    // ((String) obj).replaceFirst(null, null); // 구현하지 않은 객체를 사용하려고하면
    // 컴파일 상에 문제가 없으면 컴파일러는 통과하지만 실행 시 에러 발생!!
    ((C) obj).m3();
  }
}
