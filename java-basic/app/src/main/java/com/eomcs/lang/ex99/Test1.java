package com.eomcs.lang.ex99;

import java.io.InputStream; // InputStream : java.io 패키지에 있는 클래스
import java.util.Scanner; // import는 가져올 클래스의 위치를 컴파일러에게 알려주는 명령

public class Test1 {

  public static void main(String[] args) {
    InputStream in = System.in;
    // in.read(); // in. : in에 저장된 주소를 찾아가서 사용할 수 있는 메서드 목록을 출력해줌

    // new java.util.Scanner(in); import를 사용안하는 경우 이런 방식으로 사용해야함
    Scanner keyIn = new Scanner(in);
    String str = keyIn.nextLine();

    System.out.println("===>" + str);
    keyIn.close();
    // 프로그램이 종료되면 자동으로 회수가 되지만 지금처럼 로컬에서만 실행하는게 아니기 때문에
    // Scanner 사용이 끝나면 close를 시켜주어야 한다.
  }

}
