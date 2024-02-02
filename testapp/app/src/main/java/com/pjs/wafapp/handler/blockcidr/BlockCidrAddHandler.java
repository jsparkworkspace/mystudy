package com.pjs.wafapp.handler.blockcidr;

import com.pjs.wafapp.dao.BlockCidrDao;
import com.pjs.wafapp.vo.BlockCidr;
import com.pjs.menu.AbstractMenuHandler;
import com.pjs.util.Prompt;

public class BlockCidrAddHandler extends AbstractMenuHandler {

  private BlockCidrDao blockCidrDao;


  public BlockCidrAddHandler(BlockCidrDao blockCidrDao, Prompt prompt) {
    super(prompt);
    this.blockCidrDao = blockCidrDao;
  }

  @Override
  protected void action() {
    try {
      BlockCidr blockCidr = new BlockCidr();
      blockCidr.setRiskLevel(this.prompt.input("위험등급?(예: Critical / Major / Minor / Warning) : "));
      blockCidr.setBlockCidr(this.prompt.input("차단할 IP 혹은 CIDR? : "));
      blockCidr.setWebIp(this.prompt.input("적용할 웹서버? : "));
      blockCidr.setExpirationDate(this.prompt.inputDate("차단 만료일?(예: 2023-12-25) : "));
      blockCidr.setNote(this.prompt.input("비고? : "));

      blockCidrDao.add(blockCidr);

    } catch (Exception e) {
      System.out.println("정책 등록 중 오류 발생!");
      System.out.println("다시 시도하시기 바랍니다.");
    }
  }
}
