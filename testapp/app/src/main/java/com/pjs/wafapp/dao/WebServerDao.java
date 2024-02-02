package com.pjs.wafapp.dao;

import com.pjs.wafapp.vo.WebServer;
import java.util.List;

public interface WebServerDao {

  void add(WebServer webServer);

  int delete(int no);

  List<WebServer> findAll();

  WebServer findBy(int no);

  int update(WebServer webServer);

}
