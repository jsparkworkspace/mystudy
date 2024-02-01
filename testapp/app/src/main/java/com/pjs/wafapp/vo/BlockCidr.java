package com.pjs.wafapp.vo;

import java.io.Serializable;
import java.sql.Date;

public class BlockCidr implements Serializable {

  private static final long serialVersionUID = 100L;

  private int no;
  private String riskLevel; // 위험등급
  private String blockCidr; // 차단할 IP 혹은 네트워크
  private Date registrationDate; // 등록일
  private Date expirationDate; // 만료일
  private String note; // 비고

  @Override
  public String toString() {
    return "BlockCidr{" +
        "no=" + no +
        ", riskLevel='" + riskLevel + '\'' +
        ", blockCidr='" + blockCidr + '\'' +
        //", registrationDate=" + registrationDate +
        ", expirationDate=" + expirationDate +
        ", note=" + note +
        '}';
  }

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

  public String getBlockCidr() {
    return blockCidr;
  }

  public void setBlockCidr(String blockCidr) {
    this.blockCidr = blockCidr;
  }

//  public Date getRegistrationDate() {
//    return registrationDate;
//  }
//
//  public void setRegistrationDate(Date registrationDate) {
//    this.registrationDate = registrationDate;
//  }

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
