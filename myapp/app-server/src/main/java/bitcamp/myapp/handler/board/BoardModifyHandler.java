package bitcamp.myapp.handler.board;

import bitcamp.menu.AbstractMenuHandler;
import bitcamp.myapp.dao.AttachedFileDao;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Member;
import bitcamp.util.Prompt;
import bitcamp.util.TransactionManager;
import java.util.ArrayList;
import java.util.List;

public class BoardModifyHandler extends AbstractMenuHandler {

  private TransactionManager txManager;
  private BoardDao boardDao;
  private AttachedFileDao attachedFileDao;

  public BoardModifyHandler(TransactionManager txManager, BoardDao boardDao,
      AttachedFileDao attachedFileDao) {
    this.txManager = txManager;
    this.boardDao = boardDao;
    this.attachedFileDao = attachedFileDao;
  }

  @Override
  protected void action(Prompt prompt) {

    Member loginUser = (Member) prompt.getSession().getAttribute("loginUser");
    if (loginUser == null) {
      prompt.println("로그인하시기 바랍니다!");
      return;
    }

    try {
      int no = prompt.inputInt("번호? ");

      Board oldBoard = boardDao.findBy(no);
      if (oldBoard == null) {
        prompt.println("게시글 번호가 유효하지 않습니다.");
        return;
      } else if (oldBoard.getWriter().getNo() != loginUser.getNo()) {
        prompt.println("게시글 변경 권한이 없습니다!");
        return;
      }

      Board board = new Board();
      board.setNo(oldBoard.getNo()); // 기존 게시글의 번호를 그대로 설정한다.
      board.setTitle(prompt.input("제목(%s)? ", oldBoard.getTitle()));
      board.setContent(prompt.input("내용(%s)? ", oldBoard.getContent()));
      board.setCreatedDate(oldBoard.getCreatedDate());

      try {
        txManager.startTransaction();

        while (true) {
          String q = prompt.input("첨부파일 관리 예)1.추가 / 2.변경 / 3.삭제 / 그냥 엔터는 종료 ");
          if (q.equals("1")) {
            // 첨부파일 추가
            ArrayList<AttachedFile> files = new ArrayList<>();
            while (true) {
              String filepath = prompt.input("첨부파일?(종료는 그냥 엔터) ");
              if (filepath.length() == 0) {
                break;
              }
              files.add(new AttachedFile().filePath(filepath));
            }

            if (files.size() > 0) {
              for (AttachedFile file : files) {
                file.setBoardNo(board.getNo());
              }
              attachedFileDao.addAll(files);
            }

          } else if (q.equals("2")) {
            // 첨부파일 변경
            prompt.println("[현재 게시글의 첨부파일 리스트]");
            prompt.printf("파일번호\t첨부파일명\n");
            List<AttachedFile> files = attachedFileDao.findAllByBoardNo(no);
            for (AttachedFile file : files) {
              prompt.printf("%d\t\t   %s\n", file.getNo(), file.getFilePath());
            }
            int input2 = prompt.inputInt("변경하실 파일번호를 입력하세요 : ");
            AttachedFile attachedFile = new AttachedFile();
            attachedFile.setNo(input2);
            attachedFile.setFilePath(prompt.input("첨부파일? "));
            attachedFileDao.update(attachedFile);

          } else if (q.equals("3")) {
            // 첨부파일 삭제
            prompt.println("[현재 게시글의 첨부파일 리스트]");
            prompt.printf("파일번호\t첨부파일명\n");
            List<AttachedFile> files = attachedFileDao.findAllByBoardNo(no);
            for (AttachedFile file : files) {
              prompt.printf("%d\t\t   %s\n", file.getNo(), file.getFilePath());
            }
            int input2 = prompt.inputInt("삭제하실 파일번호를 입력하세요 : ");
            attachedFileDao.delete(input2);

          } else if (q.length() == 0) {
            // 종료
            break;
          } else {
            prompt.println("잘못 입력하셨습니다.");
          }

          String q2 = prompt.input("첨부파일 추가 작업을 하시겠습니까?(Y/n) ");
          if (q2.equals("n")) {
            break;
          }

        }

        boardDao.update(board);
        prompt.println("게시글을 변경했습니다.");

        txManager.commit();
      } catch (Exception e) {
        prompt.println("게시글 변경 오류!");
        txManager.rollback();
      }
    } catch (Exception e) {
      prompt.println("변경 오류!");

    }
  }
}
