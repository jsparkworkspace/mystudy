package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.mysql.AssignmentDaoImpl;
import bitcamp.myapp.dao.mysql.BoardDaoImpl;
import bitcamp.myapp.dao.mysql.MemberDaoImpl;
import bitcamp.myapp.handler.AboutHandler;
import bitcamp.myapp.handler.HelpHandler;
import bitcamp.myapp.handler.assignment.AssignmentAddHandler;
import bitcamp.myapp.handler.assignment.AssignmentDeleteHandler;
import bitcamp.myapp.handler.assignment.AssignmentListHandler;
import bitcamp.myapp.handler.assignment.AssignmentModifyHandler;
import bitcamp.myapp.handler.assignment.AssignmentViewHandler;
import bitcamp.myapp.handler.board.BoardAddHandler;
import bitcamp.myapp.handler.board.BoardDeleteHandler;
import bitcamp.myapp.handler.board.BoardListHandler;
import bitcamp.myapp.handler.board.BoardModifyHandler;
import bitcamp.myapp.handler.board.BoardViewHandler;
import bitcamp.myapp.handler.member.MemberAddHandler;
import bitcamp.myapp.handler.member.MemberDeleteHandler;
import bitcamp.myapp.handler.member.MemberListHandler;
import bitcamp.myapp.handler.member.MemberModifyHandler;
import bitcamp.myapp.handler.member.MemberViewHandler;
import bitcamp.util.DBConnectionPool;
import bitcamp.util.Prompt;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerApp {

  ExecutorService executorService = Executors.newCachedThreadPool();
  DBConnectionPool connectionPool;

  BoardDao boardDao;
  BoardDao greetingDao;
  AssignmentDao assignmentDao;
  MemberDao memberDao;

  MenuGroup mainMenu;

  ServerApp() {
    //prepareNetwork();
    prepareDatabase();
    prepareMenu();
  }

  public static void main(String[] args) {
    System.out.println("과제관리 시스템 서버 실행!");
    new ServerApp().run();
  }

  void prepareDatabase() {
    try {
      /*Connection con = DriverManager.getConnection(
          "jdbc:mysql://db-ld2as-kr.vpc-pub-cdb.ntruss.com/studydb", "study",
          "Bitcamp!@#123");*/

      connectionPool = new DBConnectionPool(
          "jdbc:mysql://db-ld2as-kr.vpc-pub-cdb.ntruss.com/studydb", "study",
          "Bitcamp!@#123");

      boardDao = new BoardDaoImpl(connectionPool, 1);
      greetingDao = new BoardDaoImpl(connectionPool, 2);
      assignmentDao = new AssignmentDaoImpl(connectionPool);
      memberDao = new MemberDaoImpl(connectionPool);

    } catch (Exception e) {
      System.out.println("통신 오류!");
    }
  }

  void prepareMenu() {
    mainMenu = MenuGroup.getInstance("메인");

    MenuGroup assignmentMenu = mainMenu.addGroup("과제");
    assignmentMenu.addItem("등록", new AssignmentAddHandler(connectionPool, assignmentDao));
    assignmentMenu.addItem("조회", new AssignmentViewHandler(connectionPool, assignmentDao));
    assignmentMenu.addItem("변경", new AssignmentModifyHandler(connectionPool, assignmentDao));
    assignmentMenu.addItem("삭제", new AssignmentDeleteHandler(connectionPool, assignmentDao));
    assignmentMenu.addItem("목록", new AssignmentListHandler(connectionPool, assignmentDao));

    MenuGroup boardMenu = mainMenu.addGroup("게시글");
    boardMenu.addItem("등록", new BoardAddHandler(connectionPool, boardDao));
    boardMenu.addItem("조회", new BoardViewHandler(connectionPool, boardDao));
    boardMenu.addItem("변경", new BoardModifyHandler(connectionPool, boardDao));
    boardMenu.addItem("삭제", new BoardDeleteHandler(connectionPool, boardDao));
    boardMenu.addItem("목록", new BoardListHandler(connectionPool, boardDao));

    MenuGroup memberMenu = mainMenu.addGroup("회원");
    memberMenu.addItem("등록", new MemberAddHandler(connectionPool, memberDao));
    memberMenu.addItem("조회", new MemberViewHandler(connectionPool, memberDao));
    memberMenu.addItem("변경", new MemberModifyHandler(connectionPool, memberDao));
    memberMenu.addItem("삭제", new MemberDeleteHandler(connectionPool, memberDao));
    memberMenu.addItem("목록", new MemberListHandler(connectionPool, memberDao));

    MenuGroup greetingMenu = mainMenu.addGroup("가입인사");
    greetingMenu.addItem("등록", new BoardAddHandler(connectionPool, greetingDao));
    greetingMenu.addItem("조회", new BoardViewHandler(connectionPool, greetingDao));
    greetingMenu.addItem("변경", new BoardModifyHandler(connectionPool, greetingDao));
    greetingMenu.addItem("삭제", new BoardDeleteHandler(connectionPool, greetingDao));
    greetingMenu.addItem("목록", new BoardListHandler(connectionPool, greetingDao));

    mainMenu.addItem("도움말", new HelpHandler());
    mainMenu.addItem("...대하여", new AboutHandler());
  }

  void run() {
    try (ServerSocket serverSocket = new ServerSocket(8888)) {

      while (true) {
        Socket socket = serverSocket.accept();
        executorService.execute(() -> processRequest(socket));
      }

    } catch (Exception e) {
      System.out.println("서버 소켓 생성 오류!");
      e.printStackTrace();
    }
  }

  void processRequest(Socket socket) {
    try (Socket s = socket;
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        DataInputStream in = new DataInputStream(s.getInputStream());
        Prompt prompt = new Prompt(in, out)) {

      while (true) {
        try {
          mainMenu.execute(prompt);
          prompt.print("[[quit!]]");
          prompt.end();
          break;
        } catch (Exception e) {
          System.out.println("예외 발생!");
          e.printStackTrace();
        }
      }

    } catch (Exception e) {
      System.out.println("클라이언트 통신 오류!");
      e.printStackTrace();
    } finally {
      //threadConnection.returnConnection();
    }
  }

}
