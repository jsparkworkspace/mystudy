package com.eomcs.oop.ex02.step18;

import com.eomcs.oop.ex02.step18.vo.Score;

public class App {
  public static void main(String[] args) {

    Score s1 = new Score("홍길동", 100, 90, 85);
    Score s2 = new Score("임꺽정", 90, 80, 75);
    Score s3 = new Score("유관순", 80, 70, 65);

    // 변수의 값이 바뀌면 명시적으로 compute()를 호출하여 합계와 평균을 다시 계산해야한다.
    s2.kor = 100;
    s2.compute();

    printScore(s1);
    printScore(s2);
    printScore(s3);
  }

  static void printScore(Score s) {
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }
}
