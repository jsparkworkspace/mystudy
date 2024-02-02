package com.pjs.wafapp.handler.blockfqdn;

import com.pjs.menu.AbstractMenuHandler;
import com.pjs.util.Prompt;
import com.pjs.wafapp.dao.BlockCidrDao;
import com.pjs.wafapp.dao.BlockFqdnDao;
import com.pjs.wafapp.vo.BlockCidr;
import com.pjs.wafapp.vo.BlockFqdn;

public class BlockFqdnModifyHandler extends AbstractMenuHandler {

  private BlockFqdnDao blockFqdnDao;

  public BlockFqdnModifyHandler(BlockFqdnDao blockFqdnDao, Prompt prompt) {
    super(prompt);
    this.blockFqdnDao = blockFqdnDao;
  }

  @Override
  protected void action() {
    try {
      int no = this.prompt.inputInt("수정 할 정책번호를 입력하세요 :  ");

      BlockFqdn old = blockFqdnDao.findBy(no);
      if (old == null) {
        System.out.println("정책 번호가 유효하지 않습니다!");
        return;
      }

      BlockFqdn blockFqdn = new BlockFqdn();
      blockFqdn.setNo(old.getNo());
      blockFqdn.setRiskLevel(this.prompt.input("위험등급(%s)? ", old.getRiskLevel()));
      blockFqdn.setBlockUrl(this.prompt.input("변경할 차단 IP(%s)? ", old.getBlockUrl()));
      blockFqdn.setSubDirectory(this.prompt.input("변경할 서브 디렉토리(%s)?", old.getSubDirectory()));
      blockFqdn.setExpirationDate(this.prompt.inputDate("변경할 차단 만료일(%s)? ", old.getExpirationDate()));
      blockFqdn.setNote(this.prompt.input("비고(%s)", old.getNote()));

      blockFqdnDao.update(blockFqdn);
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
