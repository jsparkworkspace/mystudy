package algorithm.test.baekjoon.level05.exam10;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String call = sc.next();
    int time = 0;

    for (int i = 0; i < call.length(); i++) {

      if (call.charAt(i) == 'A' || call.charAt(i) == 'B' || call.charAt(i) == 'C') {
        time += 3;
      } else if (call.charAt(i) == 'D' || call.charAt(i) == 'E' || call.charAt(i) == 'F') {
        time += 4;
      } else if (call.charAt(i) == 'G' || call.charAt(i) == 'H' || call.charAt(i) == 'I') {
        time += 5;
      } else if (call.charAt(i) == 'J' || call.charAt(i) == 'K' || call.charAt(i) == 'L') {
        time += 6;
      } else if (call.charAt(i) == 'M' || call.charAt(i) == 'N' || call.charAt(i) == 'O') {
        time += 7;
      } else if (call.charAt(i) == 'P' || call.charAt(i) == 'Q' || call.charAt(i) == 'R'
          || call.charAt(i) == 'S') {
        time += 8;
      } else if (call.charAt(i) == 'T' || call.charAt(i) == 'U' || call.charAt(i) == 'V') {
        time += 9;
      } else if (call.charAt(i) == 'W' || call.charAt(i) == 'X' || call.charAt(i) == 'Y'
          || call.charAt(i) == 'Z') {
        time += 10;
      } else {
        continue;
      }
    }

    System.out.println(time);

    sc.close();
  }
}
