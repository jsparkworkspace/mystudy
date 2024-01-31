package algorithm.test.baekjoon.level07.exam01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);

    int[][] a = new int[n][m];
    for (int i = 0; i < n; i++) {
      String[] row = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        a[i][j] = Integer.parseInt(row[j]);
      }
    }

    int[][] b = new int[n][m];
    for (int i = 0; i < n; i++) {
      String[] row = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        b[i][j] = Integer.parseInt(row[j]);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        bw.write(a[i][j] + b[i][j] + " ");
      }
      bw.newLine();
    }

    bw.flush();
    br.close();
    bw.close();

  }

}
