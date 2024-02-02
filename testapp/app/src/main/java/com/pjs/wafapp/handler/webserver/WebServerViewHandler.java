package com.pjs.wafapp.handler.webserver;

import com.pjs.menu.AbstractMenuHandler;
import com.pjs.util.Prompt;
import com.pjs.wafapp.dao.BlockFqdnDao;
import com.pjs.wafapp.dao.WebServerDao;
import com.pjs.wafapp.vo.BlockFqdn;
import com.pjs.wafapp.vo.WebServer;

public class WebServerViewHandler extends AbstractMenuHandler {

  private WebServerDao webServerDao;

  public WebServerViewHandler(WebServerDao webServerDao, Prompt prompt) {
    super(prompt);
    this.webServerDao = webServerDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("정책 번호? ");
      WebServer webServer = webServerDao.findBy(no);
      if (webServer == null) {
        System.out.println("정책 번호가 유효하지 않습니다!");
        return;
      }

      System.out.printf("번호: %s\n", webServer.getNo());
      System.out.printf("웹서버 IP: %s\n", webServer.getWebIp());
      System.out.printf("호스트네임: %s\n", webServer.getHostname());

    } catch (Exception e) {
      System.out.println("정책 조회 오류!");
    }
  }

}
