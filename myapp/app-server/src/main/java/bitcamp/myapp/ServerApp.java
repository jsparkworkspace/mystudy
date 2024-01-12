package bitcamp.myapp;

import bitcamp.myapp.dao.AssignmentDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.json.AssignmentDaoImpl;
import bitcamp.myapp.dao.json.BoardDaoImpl;
import bitcamp.myapp.dao.json.MemberDaoImpl;

public class ServerApp {


  AssignmentDao assignmentDao = new AssignmentDaoImpl("assignment.json");
  MemberDao memberDao = new MemberDaoImpl("member.json");
  BoardDao boardDao = new BoardDaoImpl("board.json");
  BoardDao greetingDao = new BoardDaoImpl("greeting.json");


  public static void main(String[] args) throws Exception {

    new ServerApp().run();
  }

  void run() {
    System.out.println("[과제관리 서버시스템]");
  }


}
