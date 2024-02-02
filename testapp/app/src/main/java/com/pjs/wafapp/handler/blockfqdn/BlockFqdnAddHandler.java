package com.pjs.wafapp.handler.blockfqdn;

import com.pjs.menu.AbstractMenuHandler;
import com.pjs.util.Prompt;
import com.pjs.wafapp.dao.BlockCidrDao;
import com.pjs.wafapp.dao.BlockFqdnDao;
import com.pjs.wafapp.vo.BlockCidr;
import com.pjs.wafapp.vo.BlockFqdn;

public class BlockFqdnAddHandler extends AbstractMenuHandler {

  private BlockFqdnDao blockFqdnDao;


  public BlockFqdnAddHandler(BlockFqdnDao blockFqdnDao, Prompt prompt) {
    super(prompt);
    this.blockFqdnDao = blockFqdnDao;
  }

  @Override
  protected void action() {
    try {
      BlockFqdn blockFqdn = new BlockFqdn();
      blockFqdn.setRiskLevel(this.prompt.input("위험등급?(예: Critical / Major / Minor / Warning) : "));
      blockFqdn.setBlockUrl(this.prompt.input("차단할 URL?(예: www.warning.com) : "));
      blockFqdn.setSubDirectory(this.prompt.input("서브디렉토리?(예: /[index.html]) : "));
      blockFqdn.setExpirationDate(this.prompt.inputDate("차단 만료일?(예: 2023-12-25) : "));
      blockFqdn.setNote(this.prompt.input("비고? : "));

      blockFqdnDao.add(blockFqdn);

    } catch (Exception e) {
      System.out.println("정책 등록 중 오류 발생!");
      System.out.println("다시 시도하시기 바랍니다.");
    }
  }
}
