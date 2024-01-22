package nettest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    try {
      ServerSocket serverSocket = new ServerSocket(8888);
      System.out.println("서버 실행 중...");

      try (Socket socket = serverSocket.accept();
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          PrintWriter out = new PrintWriter(socket.getOutputStream())) {

        sendMessages(out);

        while (true) {
          String request = in.readLine();
          sendResponse(out, request);
        }

      }


    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static public void sendMessages(PrintWriter out) {
    out.println("tlqkf 너무 어려운 계산기");
    out.println("계산식을 입력해주세요");
    out.println("예) 23 + 7");
    out.println();
    out.flush();
  }

  static public void sendResponse(PrintWriter out, String request) throws Exception {

    out.println(request);
    out.println();
    out.flush();

  }

}
