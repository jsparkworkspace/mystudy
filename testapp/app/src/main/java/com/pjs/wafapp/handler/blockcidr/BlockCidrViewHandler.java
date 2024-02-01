package com.pjs.wafapp.handler.blockcidr;

import com.pjs.wafapp.dao.BlockCidrDao;
import com.pjs.wafapp.vo.BlockCidr;
import com.pjs.menu.AbstractMenuHandler;
import com.pjs.util.Prompt;

public class BlockCidrViewHandler extends AbstractMenuHandler {

  private BlockCidrDao blockCidrDao;

  public BlockCidrViewHandler(BlockCidrDao blockCidrDao, Prompt prompt) {
    super(prompt);
    this.blockCidrDao = blockCidrDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("정책 번호? ");
      BlockCidr blockCidr = blockCidrDao.findBy(no);
      if (blockCidr == null) {
        System.out.println("정책 번호가 유효하지 않습니다!");
        return;
      }

      System.out.printf("번호: %s\n", blockCidr.getNo());
      System.out.printf("위험등급: %s\n", blockCidr.getRiskLevel());
      System.out.printf("차단 IP: %s\n", blockCidr.getBlockCidr());
      System.out.printf("정책 만료일: %s\n", blockCidr.getExpirationDate());
      System.out.printf("비고: %s\n", blockCidr.getNote());

    } catch (Exception e) {
      System.out.println("정책 조회 오류!");
    }
  }

}
