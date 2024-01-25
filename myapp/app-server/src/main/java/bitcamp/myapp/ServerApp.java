package bitcamp.myapp;

import bitcamp.RequestException;
import bitcamp.myapp.dao.json.AssignmentDaoImpl;
import bitcamp.myapp.dao.json.BoardDaoImpl;
import bitcamp.myapp.dao.json.MemberDaoImpl;
import bitcamp.util.ThreadPool;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ServerApp {

  ThreadPool threadPool = new ThreadPool();
  HashMap<String, Object> daoMap = new HashMap<>();
  Gson gson;

  public ServerApp() {
    daoMap.put("board", new BoardDaoImpl("board.json"));
    daoMap.put("greeting", new BoardDaoImpl("greeting.json"));
    daoMap.put("assignment", new AssignmentDaoImpl("assignment.json"));
    daoMap.put("member", new MemberDaoImpl("member.json"));

    gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
  }

  public static void main(String[] args) {
    new ServerApp().run();
  }

  void run() {
    System.out.println("[과제관리 서버시스템]");

    try (ServerSocket serverSocket = new ServerSocket(8888)) {

      System.out.println("서버 실행!");

      while (true) {
        Socket socket = serverSocket.accept();
        threadPool.get().setWorker(() -> service(socket));
      }

    } catch (Exception e) {
      System.out.println("통신 오류!");
      e.printStackTrace();
    }
  }

  void service(Socket socket) {
    try (Socket s = socket; DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

      System.out.printf("[%s] 클라이언트와 연결됨!", Thread.currentThread().getName());

      processRequest(in, out);

      System.out.printf("[%s] 클라이언트 연결 종료!", Thread.currentThread().getName());

    } catch (Exception e) {
      System.out.printf("[%s] 클라이언트 연결 오류!", Thread.currentThread().getName());
    }
  }

  void processRequest(DataInputStream in, DataOutputStream out) throws IOException {

    System.out.println("[클라이언트 요청]");
    String dataName = in.readUTF();
    String command = in.readUTF();
    String value = in.readUTF();

    try {
      // dataName으로 DAO를 찾는다.
      Object dao = daoMap.get(dataName);
      if (dao == null) {
        throw new RequestException("요청 데이터가 없습니다!");
      }
      System.out.printf("데이터: %s\n", dataName);

      Method commandHandler = findMethod(dao.getClass(), command);
      System.out.printf("메서드: %s\n", commandHandler.getName());

      Object[] args = getArguments(commandHandler, value);

      // 메서드의 리턴 타입을 알아낸다.
//      Class<?> returnType = commandHandler.getReturnType();
//      System.out.printf("리턴: %s\n", returnType.getName());

      // 메서드를 호출한다.
      Object returnValue = commandHandler.invoke(dao, args);

      out.writeUTF("200");
      out.writeUTF(gson.toJson(returnValue));
      System.out.println("클라이언트에게 응답 완료!");
    } catch (RequestException e) {
      out.writeUTF("400");
      out.writeUTF(gson.toJson(e.getMessage()));
    } catch (Exception e) {
      out.writeUTF("500");
      out.writeUTF(gson.toJson(e.getMessage()));
    }
  }

  Method findMethod(Class<?> clazz, String name) {
    // command 이름으로 메서드를 찾는다.
    Method[] methods = clazz.getDeclaredMethods();
    for (Method m : methods) {
      if (m.getName().equals(name)) {
        return m;
      }
    }
    throw new RequestException("요청 메서드가 없습니다!");
  }

  Object[] getArguments(Method m, String json) {
    // 메서드의 파라미터 정보를 알아낸다.
    Parameter[] params = m.getParameters();
    System.out.printf("파라미터 개수: %d\n", params.length);

    // 메서드를 호출할 때 파라미터에 넘겨 줄 데이터를 담을 배열을 준비한다.
    Object[] args = new Object[params.length];

    // 아규먼트 값 준비하기
    // => 현재 모든 DAO의 메서드는 파라미터가 최대 1개만 있다.
    // => 1개만 있다는 가정하에서 아규먼트 값을 준비한다.
    if (params.length > 0) {
      // 파라미터 타입을 알아낸다.
      Class<?> paramType = params[0].getType();

      // 클라이언트가 보낸 JSON 문자열을 해당 파라미터 타입 객체로 변환한다.
      Object paramValue = gson.fromJson(json, paramType);

      // 아규먼트 배열에 저장한다.
      args[0] = paramValue;
    }

    return args;
  }

}
