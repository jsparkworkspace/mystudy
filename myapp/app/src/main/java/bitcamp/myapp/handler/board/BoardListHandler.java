package bitcamp.myapp.handler.board;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.AnsiEscape;
import bitcamp.util.ObjectRepository;

public class BoardListHandler implements MenuHandler {

  ObjectRepository<Board> objectRepository;

  public BoardListHandler(ObjectRepository<Board> objectRepository) {
    this.objectRepository = objectRepository;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());
    System.out.printf("%-20s\t%10s\t%s\n", "Title", "Writer", "Date");

    // Repository에 보관된 목록을 배열로 리턴 받기
    // 방법 1)
//    Board[] boards = new Board[this.objectRepository.size()];
//    this.objectRepository.toArray(boards);

    //방법 2)
    Board[] boards = this.objectRepository.toArray(new Board[0]);

    for (Board board : boards) {
      System.out.printf("%-20s\t%10s\t%s\n", board.title, board.writer, board.createdDate);
    }
  }
}
