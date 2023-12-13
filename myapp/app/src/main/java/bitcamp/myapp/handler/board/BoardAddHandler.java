package bitcamp.myapp.handler.board;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Board;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;
import java.util.ArrayList;

public class BoardAddHandler implements MenuHandler {

  Prompt prompt;
  ArrayList<Board> objectRepository;

  public BoardAddHandler(ArrayList<Board> boardRepository, Prompt prompt) {
    this.objectRepository = boardRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    Board board = new Board();
    board.title = this.prompt.input("제목? ");
    board.content = this.prompt.input("내용? ");
    board.writer = this.prompt.input("작성자? ");
    board.createdDate = this.prompt.input("작성일? ");

    objectRepository.add(board);
    // 레퍼런스를 선언하는 시점에 지정된 타입이 아닌 값을 넣으려고 하면 컴파일 오류가 발생한다.
    // 즉, 특정 타입만 사용하도록 제한할 수 있는 문법이 제네릭(jeneric) 이다.
    // objectRepository.add(new String("Hello")); - 컴파일 에러
  }
}
