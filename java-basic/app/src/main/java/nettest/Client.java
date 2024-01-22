package nettest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

  public static void main(String[] agrs) {

    try (Scanner sc = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(socket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

      readResponse(in);
      while (true) {
        String input = sc.nextLine();
        sendRequest(out, input);
        readResponse(in); // 서버의 실행 결과를 출력
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  static void readResponse(BufferedReader in) throws Exception {
    while (true) {
      String input = in.readLine();
      if (input.length() == 0) {
        break;
      }
      System.out.println(input);
    }
  }

  static void sendRequest(PrintStream out, String input) {
    out.println(input);
    out.flush();

  }
}
