package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

  public static void main(String[] args) {

    try (Scanner sc = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8888);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream out = new PrintStream(socket.getOutputStream())) {

      readResponse(in);

      while (true) {
        String request = sc.nextLine();
        out.println(request);
        out.println();
        out.flush();

        readResponse(in);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static public void readResponse(BufferedReader in) throws Exception {
    while (true) {
      String input = in.readLine();
      if (input.equals("")) { // 객체의 비교연산자는 동일한 객체인지 확인한다. equals()는 값을 비교
        break;
      }
      System.out.println(input);
    }
  }

  static void sendRequest(PrintStream out, String request) {

  }

}
