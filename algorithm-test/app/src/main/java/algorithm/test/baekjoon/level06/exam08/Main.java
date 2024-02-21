package algorithm.test.baekjoon.level06.exam08;

import java.util.Scanner;

public class Main {
  static double sum = 0;
  static double scoreSum = 0;

  static void operator(double score, double num) {
    sum = sum + score * num;
    scoreSum += score;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);


    for (int i = 0; i < 20; i++) {
      String major = sc.next();
      double score = sc.nextDouble();

      String g = sc.next();
      switch (g) {
        case "A+":
          operator(score, 4.5);
          break;
        case "A0":
          operator(score, 4.0);
          break;
        case "B+":
          operator(score, 3.5);
          break;
        case "B0":
          operator(score, 3.0);
          break;
        case "C+":
          operator(score, 2.5);
          break;
        case "C0":
          operator(score, 2.0);
          break;
        case "D+":
          operator(score, 1.5);
          break;
        case "D0":
          operator(score, 1.0);
          break;
        case "F":
          operator(score, 0.0);
          break;
        default:
          break;
      }

    }
    System.out.printf("%.6f", sum / scoreSum);

    sc.close();
  }
}
