package com.pjs.wafapp.handler.blockcidr;

import com.pjs.wafapp.dao.BlockCidrDao;
import com.pjs.wafapp.vo.BlockCidr;
import com.pjs.menu.AbstractMenuHandler;
import com.pjs.util.Prompt;

public class BlockCidrModifyHandler extends AbstractMenuHandler {

  private BlockCidrDao blockCidrDao;

  public BlockCidrModifyHandler(BlockCidrDao blockCidrDao, Prompt prompt) {
    super(prompt);
    this.blockCidrDao = blockCidrDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("수정 할 정책번호를 입력하세요 :  ");

      BlockCidr old = blockCidrDao.findBy(no);
      if (old == null) {
        System.out.println("정책 번호가 유효하지 않습니다!");
        return;
      }

      BlockCidr blockCidr = new BlockCidr();
      blockCidr.setNo(old.getNo());
      blockCidr.setRiskLevel(this.prompt.input("위험등급(%s)? ", old.getRiskLevel()));
      blockCidr.setBlockCidr(this.prompt.input("변경할 차단 IP(%s)? ", old.getBlockCidr()));
      blockCidr.setExpirationDate(this.prompt.inputDate("변경할 차단 만료일(%s)? ", old.getExpirationDate()));
      blockCidr.setNote(this.prompt.input("비고(%s)", old.getNote()));

      blockCidrDao.update(blockCidr);
      System.out.println("성공적으로 정책을 수정했습니다.");

    } catch (NumberFormatException e) {
      System.out.println("숫자를 입력하세요!");

    } catch (IllegalArgumentException e) {
      System.out.println("정책 수정 오류!");
      System.out.println("다시 시도 하세요.");

    } catch (Exception e) {
      System.out.println("정책 수정 오류!");
      e.printStackTrace();
    }

  }
}
