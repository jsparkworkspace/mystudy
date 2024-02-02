package com.pjs.wafapp.handler.webserver;

import com.pjs.menu.AbstractMenuHandler;
import com.pjs.util.Prompt;
import com.pjs.wafapp.dao.BlockFqdnDao;
import com.pjs.wafapp.dao.WebServerDao;

public class WebServerDeleteHandler extends AbstractMenuHandler {

  private WebServerDao webServerDao;

  public WebServerDeleteHandler(WebServerDao webServerDao, Prompt prompt) {
    super(prompt);
    this.webServerDao = webServerDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("삭제할 정책 번호를 입력하세요 : ");
      if (webServerDao.delete(no) == 0) {
        System.out.println("정책 번호가 유효하지 않습니다!");
      } else {
        System.out.println("성공적으로 정책을 삭제했습니다.");
      }

    } catch (Exception e) {
      System.out.println("정책 삭제 오류!");
    }
  }
}