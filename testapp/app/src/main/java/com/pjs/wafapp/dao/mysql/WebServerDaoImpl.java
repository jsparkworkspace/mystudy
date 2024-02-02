package com.pjs.wafapp.dao.mysql;

import com.pjs.wafapp.dao.DaoException;
import com.pjs.wafapp.dao.WebServerDao;
import com.pjs.wafapp.vo.BlockFqdn;
import com.pjs.wafapp.vo.WebServer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WebServerDaoImpl implements WebServerDao {

  Connection con;

  public WebServerDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(WebServer webServer) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(String.format(
          "insert into web_server(web_ip,hostname) values('%s','%s')",
          webServer.getWebIp(), webServer.getHostname()));

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(
          String.format("delete from web_server where web_no=%d", no));
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public List<WebServer> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from web_server");

      ArrayList<WebServer> list = new ArrayList<>();

      while (rs.next()) {
        WebServer webServer = new WebServer();
        webServer.setNo(rs.getInt("web_no"));
        webServer.setWebIp(rs.getString("web_ip"));
        webServer.setHostname(rs.getString("hostname"));


        list.add(webServer);
      }
      return list;
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public WebServer findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from web_server where web_no = " + no);

      if (rs.next()) {
        WebServer webServer = new WebServer();
        webServer.setNo(rs.getInt("web_no"));
        webServer.setWebIp(rs.getString("web_ip"));
        webServer.setHostname(rs.getString("hostname"));

        return webServer;
      }
      return null;
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(WebServer webServer) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
          "update web_server set web_ip='%s', hostname='%s' where web_no=%d",
          webServer.getWebIp(), webServer.getHostname(), webServer.getNo()));
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }
}