// Object 클래스 - clone() 사용법 I
package com.eomcs.basic.ex01.test;

// clone()은 인스턴스를 복제할 때 호출하는 메서드이다.

public class Score implements Cloneable {

  String name;
  int kor;
  int eng;
  int math;
  int sum;
  float aver;

  public Score() {}

  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }

  @Override
  public String toString() {
    return "Score [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
        + sum + ", aver=" + aver + "]";


  }

  public void test() throws CloneNotSupportedException {
    Score s4 = (Score) this.clone();
    System.out.println("s4 : " + s4);
  }

}


