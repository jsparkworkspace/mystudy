package com.eomcs.oop.ex02.step18.vo;


public class Score {

  public String name;
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;

  // 생성자가 없으면 컴파일러가 자동으로 default 생성자를 생성한다.
  // public Score() {
  //
  // }
  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;

    this.compute();
  }

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = (float) this.sum / 3;
  }

}
