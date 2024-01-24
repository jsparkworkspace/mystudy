package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] agrs) {

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중");

      try (Socket socket = serverSocket.accept();
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          PrintStream out = new PrintStream(socket.getOutputStream());) {

        sendIntroMessage(out);

        while (true) {
          String request = in.readLine();
          out.println(request);
          out.println();
          out.flush();
        }

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static public void sendIntroMessage(PrintStream out) {
    out.println("계산기 서버에 오신것을 환영합니다.");
    out.println("계산식을 입력하세요!");
    out.println("예) 23 + 7");
    out.println();
    out.flush();
  }

  static public void sendResponse(PrintStream out, String request) throws Exception {

  }
}
