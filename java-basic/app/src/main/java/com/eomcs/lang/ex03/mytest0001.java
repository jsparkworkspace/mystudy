package com.eomcs.lang.ex03;

public class mytest0001 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    System.out.println(35); // int = 32bit = 4byte
    System.out.println(35L); // long = 64bit = 8byte

    System.out.println(035);
    System.out.println(0x35);
    System.out.println(0b0101 + "\n");

    System.out.println(Float.MAX_VALUE);
    System.out.println(Float.MIN_VALUE);
    System.out.println(35.12345f); // float = 32bit = 4byte | 유효자릿수 = 7
    System.out.println(35.12345E-3f);

    System.out.println(Double.MAX_VALUE);
    System.out.println(Double.MIN_VALUE);
    System.out.println(35.12345678901234 + "\n"); // double = 64bit = 8byte | 유효자릿수 = 16

    System.out.println('A');
    System.out.println('\u0061');
    System.out.println('"');
    System.out.println("'");
    System.out.println("'/'");
    System.out.println((int) '가');
    System.out.println('가' + 1);
    System.out.println("가" + 1);
  }

}
