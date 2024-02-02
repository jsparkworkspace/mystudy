package com.pjs.wafapp.dao.mysql;

import com.pjs.wafapp.dao.BlockCidrDao;
import com.pjs.wafapp.dao.DaoException;
import com.pjs.wafapp.vo.BlockCidr;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BlockCidrDaoImpl implements BlockCidrDao {

  Connection con;

  public BlockCidrDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(BlockCidr blockCidr) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(String.format(
          "insert into cidr_block_pol(risk_level,block_cidr,web_ip,expiration_date,note) values('%s','%s','%s','%s','%s')",
          blockCidr.getRiskLevel(), blockCidr.getBlockCidr(), blockCidr.getWebIp(), blockCidr.getExpirationDate(), blockCidr.getNote()));

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(
          String.format("delete from cidr_block_pol where cidr_pol_no=%d", no));
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public List<BlockCidr> findAll() {
    try {
      Statement stmt = con.createStatement();
      //ResultSet rs = stmt.executeQuery("select * from cidr_block_pol");
      ResultSet rs = stmt.executeQuery("select cbp.cidr_pol_no, cbp.risk_level, cbp.block_cidr, cbp.expiration_date, ws.hostname, cbp.note\n"
          + "  from cidr_block_pol cbp\n"
          + "  join web_server ws on cbp.web_ip=ws.web_ip");

      ArrayList<BlockCidr> list = new ArrayList<>();

      while (rs.next()) {
        BlockCidr blockCidr = new BlockCidr();
        blockCidr.setNo(rs.getInt("cidr_pol_no"));
        blockCidr.setRiskLevel(rs.getString("risk_level"));
        blockCidr.setBlockCidr(rs.getString("block_cidr"));
        //blockCidr.setWebIp(rs.getString("web_ip"));
        blockCidr.setHostname(rs.getString("hostname"));
        blockCidr.setExpirationDate(rs.getDate("expiration_date"));
        blockCidr.setNote(rs.getString("note"));

        list.add(blockCidr);
      }
      return list;
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public BlockCidr findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from cidr_block_pol where cidr_pol_no = " + no);

      if (rs.next()) {
        BlockCidr blockCidr = new BlockCidr();
        blockCidr.setNo(rs.getInt("cidr_pol_no"));
        blockCidr.setRiskLevel(rs.getString("risk_level"));
        blockCidr.setBlockCidr(rs.getString("block_cidr"));
        blockCidr.setWebIp(rs.getString("web_ip"));
        blockCidr.setExpirationDate(rs.getDate("expiration_date"));
        blockCidr.setNote(rs.getString("note"));

        return blockCidr;
      }
      return null;
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(BlockCidr blockCidr) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
          "update cidr_block_pol set risk_level='%s', block_cidr='%s', web_ip='%s',expiration_date='%s', note='%s' where cidr_pol_no=%d",
          blockCidr.getRiskLevel(), blockCidr.getBlockCidr(), blockCidr.getWebIp(), blockCidr.getExpirationDate(), blockCidr.getNote(),
          blockCidr.getNo()));
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }
}