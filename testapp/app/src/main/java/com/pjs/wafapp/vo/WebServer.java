package com.pjs.wafapp.vo;

import java.io.Serializable;
import java.sql.Date;

public class WebServer implements Serializable {

//  private static final long serialVersionUID = 100L;

  private int no;
  private String webIp; // 웹서버 IP
  private String hostname; // 웹서버 호스트네임


  /*@Override
  public String toString() {
    return "WebServer{" +
        "no=" + no +
        ", webIp='" + webIp + '\'' +
        ", hostname='" + hostname + '\'' +
        '}';
  }*/

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getWebIp() {
    return webIp;
  }

  public void setWebIp(String webIp) {
    this.webIp = webIp;
  }

  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }
}
