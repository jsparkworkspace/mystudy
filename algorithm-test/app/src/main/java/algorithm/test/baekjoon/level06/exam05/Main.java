package algorithm.test.baekjoon.level06.exam05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine().toUpperCase();

    int[] cnt = new int[26]; // 알파벳 개수 저장용 배열 생성
    // 문자열에서 각 문자에 해당하는 배열 값 카운트 증가
    // => 문자 - 'A' = 해당 알파벳 배열 위치
    // => 예) 'A' - 'A' => 65 - 65 = 0 (아스키 코드 10진수 참고)
    // => 예) 'B' - 'A' => 66 - 65 = 1
    for (int i = 0; i < str.length(); i++) {
      cnt[str.charAt(i) - 'A']++;
    }

    int maxCnt = 0;
    char alpha = ' ';
    for (int i = 0; i < cnt.length; i++) {
      if (cnt[i] > maxCnt) {
        maxCnt = cnt[i];
        alpha = (char) ('A' + i);
      } else if (cnt[i] == maxCnt) {
        alpha = '?';
      }
    }
    System.out.println(alpha);


    br.close();
  }
}
