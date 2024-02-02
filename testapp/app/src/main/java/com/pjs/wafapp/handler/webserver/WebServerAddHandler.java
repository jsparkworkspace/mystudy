package com.pjs.wafapp.handler.webserver;

import com.pjs.menu.AbstractMenuHandler;
import com.pjs.util.Prompt;
import com.pjs.wafapp.dao.WebServerDao;
import com.pjs.wafapp.vo.WebServer;

public class WebServerAddHandler extends AbstractMenuHandler {

  private WebServerDao webServerDao;


  public WebServerAddHandler(WebServerDao webServerDao, Prompt prompt) {
    super(prompt);
    this.webServerDao = webServerDao;
  }

  @Override
  protected void action() {
    try {
      WebServer webServer = new WebServer();
      webServer.setWebIp(this.prompt.input("웹서버 IP?(예: 192.168.0.x) : "));
      webServer.setHostname(this.prompt.input("웹서버 호스트네임?(예: WIN-FWK9DI) : "));

      webServerDao.add(webServer);

    } catch (Exception e) {
      System.out.println("정책 등록 중 오류 발생!");
      System.out.println("다시 시도하시기 바랍니다.");
    }
  }
}
