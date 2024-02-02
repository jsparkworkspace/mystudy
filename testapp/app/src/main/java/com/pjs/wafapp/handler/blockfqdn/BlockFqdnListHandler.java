package com.pjs.wafapp.handler.blockfqdn;

import com.pjs.menu.AbstractMenuHandler;
import com.pjs.util.Prompt;
import com.pjs.wafapp.dao.BlockCidrDao;
import com.pjs.wafapp.dao.BlockFqdnDao;
import com.pjs.wafapp.vo.BlockCidr;
import com.pjs.wafapp.vo.BlockFqdn;
import java.util.List;

public class BlockFqdnListHandler extends AbstractMenuHandler {

  private BlockFqdnDao blockFqdnDao;

  public BlockFqdnListHandler(BlockFqdnDao blockFqdnDao, Prompt prompt) {
    super(prompt);
    this.blockFqdnDao = blockFqdnDao;
  }

  @Override
  protected void action() {
    System.out.printf("%-4s\t%-10s\t%-30s\t%-15s\t%-20s\n", "정책번호", "위험등급", "차단 URL", "만료일", "비고");

    List<BlockFqdn> list = blockFqdnDao.findAll();

    for (BlockFqdn blockFqdn : list) {
      System.out.printf("%-7d\t%-12s\t%-30s\t%-16s\t%-20s\n",
          blockFqdn.getNo(),
          blockFqdn.getRiskLevel(),
          blockFqdn.getBlockUrl() + blockFqdn.getSubDirectory(),
          blockFqdn.getExpirationDate(),
          blockFqdn.getNote());
    }
  }
}
