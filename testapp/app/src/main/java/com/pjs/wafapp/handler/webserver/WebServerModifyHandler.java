package com.pjs.wafapp.handler.webserver;

import com.pjs.menu.AbstractMenuHandler;
import com.pjs.util.Prompt;
import com.pjs.wafapp.dao.BlockFqdnDao;
import com.pjs.wafapp.dao.WebServerDao;
import com.pjs.wafapp.vo.BlockFqdn;
import com.pjs.wafapp.vo.WebServer;

public class WebServerModifyHandler extends AbstractMenuHandler {

  private WebServerDao webServerDao;

  public WebServerModifyHandler(WebServerDao webServerDao, Prompt prompt) {
    super(prompt);
    this.webServerDao = webServerDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("수정 할 정책번호를 입력하세요 :  ");

      WebServer old = webServerDao.findBy(no);
      if (old == null) {
        System.out.println("정책 번호가 유효하지 않습니다!");
        return;
      }

      WebServer webServer = new WebServer();
      webServer.setNo(old.getNo());
      webServer.setWebIp(this.prompt.input("웹서버 IP(%s)? ", old.getWebIp()));
      webServer.setHostname(this.prompt.input("웹서버 호스트네임(%s)? ", old.getHostname()));

      webServerDao.update(webServer);
      System.out.println("성공적으로 정책을 수정했습니다.");

    } catch (NumberFormatException e) {
      System.out.println("숫자를 입력하세요!");

    } catch (IllegalArgumentException e) {
      System.out.println("정책 수정 오류!");
      System.out.println("다시 시도 하세요.");

    } catch (Exception e) {
      System.out.println("정책 수정 오류!");
      e.printStackTrace();
    }

  }
}
