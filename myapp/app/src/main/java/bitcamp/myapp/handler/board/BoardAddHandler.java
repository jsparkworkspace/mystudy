package bitcamp.myapp.handler.board;

import bitcamp.menu.Menu;
import bitcamp.menu.MenuHandler;
import bitcamp.myapp.vo.Object;
import bitcamp.util.AnsiEscape;
import bitcamp.util.Prompt;

// 게시글의 '등록' 메뉴를 선택했을 때 작업을 수행하는 클래스
// - 반드시 MenuHandler 규칙에 따라 클래스를 작성해야 한다.
//
public class BoardAddHandler implements MenuHandler {

  Prompt prompt;
  BoardRepository boardRepository;

  public BoardAddHandler(BoardRepository boardRepository, Prompt prompt) {
    this.boardRepository = boardRepository;
    this.prompt = prompt;
  }

  @Override
  public void action(Menu menu) {
    System.out.printf(AnsiEscape.ANSI_BOLD + "[%s]\n" + AnsiEscape.ANSI_CLEAR, menu.getTitle());

    // 제거
//    if (this.boardRepository.length == this.boardRepository.boards.length) {
//      int oldSize = this.boardRepository.boards.length;
//      int newSize = oldSize + (oldSize >> 1);
//
//      Board[] arr = new Board[newSize];
//      for (int i = 0; i < oldSize; i++) {
//        arr[i] = this.boardRepository.boards[i];
//      }
//
//      this.boardRepository.boards = arr;
//    }

    Object board = new Object();
    board.title = this.prompt.input("제목? ");
    board.content = this.prompt.input("내용? ");
    board.writer = this.prompt.input("작성자? ");
    board.createdDate = this.prompt.input("작성일? ");

    // 제거
    // this.boardRepository.boards[this.boardRepository.length++] = board;

    // 추가 - 목록에 객체를 추가시키는 코드를 BoardRepository가 감췄다. => 캡슐화 했다.
    // 대신 목록에 객체를 추가시킬 수 있도록 메서드를 제공하고 있다.
    // 따라서 다음과 같이 BoardRepository가 제공하는 메서드를 사용하여 게시글 객체를 추가한다.
    boardRepository.add(board);
  }
}
