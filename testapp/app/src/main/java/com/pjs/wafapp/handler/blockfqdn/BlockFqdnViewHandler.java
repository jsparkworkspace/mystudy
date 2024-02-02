package com.pjs.wafapp.handler.blockfqdn;

import com.pjs.menu.AbstractMenuHandler;
import com.pjs.util.Prompt;
import com.pjs.wafapp.dao.BlockCidrDao;
import com.pjs.wafapp.dao.BlockFqdnDao;
import com.pjs.wafapp.vo.BlockCidr;
import com.pjs.wafapp.vo.BlockFqdn;

public class BlockFqdnViewHandler extends AbstractMenuHandler {

  private BlockFqdnDao blockFqdnDao;

  public BlockFqdnViewHandler(BlockFqdnDao blockFqdnDao, Prompt prompt) {
    super(prompt);
    this.blockFqdnDao = blockFqdnDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("정책 번호? ");
      BlockFqdn blockFqdn = blockFqdnDao.findBy(no);
      if (blockFqdn == null) {
        System.out.println("정책 번호가 유효하지 않습니다!");
        return;
      }

      System.out.printf("번호: %s\n", blockFqdn.getNo());
      System.out.printf("위험등급: %s\n", blockFqdn.getRiskLevel());
      System.out.printf("차단 URL: %s\n", blockFqdn.getBlockUrl());
      System.out.printf("서브디렉토리: %s\n", blockFqdn.getSubDirectory());
      System.out.printf("정책 만료일: %s\n", blockFqdn.getExpirationDate());
      System.out.printf("비고: %s\n", blockFqdn.getNote());

    } catch (Exception e) {
      System.out.println("정책 조회 오류!");
    }
  }

}
