package com.pjs.wafapp.handler.blockcidr;

import com.pjs.wafapp.dao.BlockCidrDao;
import com.pjs.wafapp.vo.BlockCidr;
import com.pjs.menu.AbstractMenuHandler;
import com.pjs.util.Prompt;
import java.util.List;

public class BlockCidrListHandler extends AbstractMenuHandler {

  private BlockCidrDao blockCidrDao;

  public BlockCidrListHandler(BlockCidrDao blockCidrDao, Prompt prompt) {
    super(prompt);
    this.blockCidrDao = blockCidrDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-10s\t%-20s\t%-20s\t%-20s\t%-20s\n", "정책번호", "위험등급", "차단 IP", "적용된 웹서버", "만료일", "비고");

    List<BlockCidr> list = blockCidrDao.findAll();

    for (BlockCidr blockCidr : list) {
      System.out.printf("%-7d\t%-12s\t%-20s\t%-24s\t%-22s\t%-18s\n",
          blockCidr.getNo(),
          blockCidr.getRiskLevel(),
          blockCidr.getBlockCidr(),
          //blockCidr.getWebIp(),
          blockCidr.getHostname(),
          blockCidr.getExpirationDate(),
          blockCidr.getNote());
    }
  }
}
