package com.eomcs.oop.ex02.test.util;

public class Calculator {

  public int result = 0;

  public void plus(int vaule) {
    this.result += vaule;
  }

  public void minus(int vaule) {
    this.result -= vaule;
  }

  public void multiple(int vaule) {
    this.result *= vaule;
  }

  public void divide(int vaule) {
    this.result /= vaule;
  }
}
