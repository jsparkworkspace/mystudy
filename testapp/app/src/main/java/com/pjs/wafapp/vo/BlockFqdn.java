package com.pjs.wafapp.vo;

import java.io.Serializable;
import java.sql.Date;

public class BlockFqdn implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String riskLevel; // 위험등급
  private String blockUrl; // 차단할 URL
  private String subDirectory; // 서브 디렉토리
  private Date expirationDate; // 만료일
  private String note; // 비고

  /*@Override
  public String toString() {
    return "BlockCidr{" +
        "no=" + no +
        ", riskLevel='" + riskLevel + '\'' +
        ", blockCidr='" + blockUrl + '\'' +
        ", subDirectory=" + subDirectory +
        ", expirationDate=" + expirationDate +
        ", note=" + note +
        '}';
  }*/

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getRiskLevel() {
    return riskLevel;
  }

  public void setRiskLevel(String riskLevel) {
    this.riskLevel = riskLevel;
  }

  public String getBlockUrl() {
    return blockUrl;
  }

  public void setBlockUrl(String blockUrl) {
    this.blockUrl = blockUrl;
  }

  public String getSubDirectory() {
    return subDirectory;
  }

  public void setSubDirectory(String subDirectory) {
    this.subDirectory = subDirectory;
  }

  public Date getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(Date expirationDate) {
    this.expirationDate = expirationDate;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }
}
