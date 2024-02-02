package com.pjs.wafapp.handler.webserver;

import com.pjs.menu.AbstractMenuHandler;
import com.pjs.util.Prompt;
import com.pjs.wafapp.dao.BlockFqdnDao;
import com.pjs.wafapp.dao.WebServerDao;
import com.pjs.wafapp.vo.BlockFqdn;
import com.pjs.wafapp.vo.WebServer;
import java.util.List;

public class WebServerListHandler extends AbstractMenuHandler {

  private WebServerDao webServerDao;

  public WebServerListHandler(WebServerDao webServerDao, Prompt prompt) {
    super(prompt);
    this.webServerDao = webServerDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-10s\t%-20s\n", "정책번호", "웹서버 IP", "호스트네임");

    List<WebServer> list = webServerDao.findAll();

    for (WebServer webServer : list) {
      System.out.printf("%-7d\t%-12s\t%-20s\n",
          webServer.getNo(),
          webServer.getWebIp(),
          webServer.getHostname());
    }
  }
}
