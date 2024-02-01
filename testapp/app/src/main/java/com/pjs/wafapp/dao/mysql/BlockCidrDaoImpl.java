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
          "insert into blockpolicy(risk_level,block_cidr,expiration_date,note) values('%s','%s','%s','%s')",
          blockCidr.getRiskLevel(), blockCidr.getBlockCidr(), blockCidr.getExpirationDate(), blockCidr.getNote()));

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(
          String.format("delete from blockpolicy where block_cidr_no=%d", no));
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public List<BlockCidr> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from blockpolicy");

      ArrayList<BlockCidr> list = new ArrayList<>();

      while (rs.next()) {
        BlockCidr blockCidr = new BlockCidr();
        blockCidr.setNo(rs.getInt("block_cidr_no"));
        blockCidr.setRiskLevel(rs.getString("risk_level"));
        blockCidr.setBlockCidr(rs.getString("block_cidr"));
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
      ResultSet rs = stmt.executeQuery("select * from blockpolicy where block_cidr_no = " + no);

      if (rs.next()) {
        BlockCidr blockCidr = new BlockCidr();
        blockCidr.setNo(rs.getInt("block_cidr_no"));
        blockCidr.setRiskLevel(rs.getString("risk_level"));
        blockCidr.setBlockCidr(rs.getString("block_cidr"));
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
          "update blockpolicy set risk_level='%s', block_cidr='%s', expiration_date='%s', note='%s' where block_cidr_no=%d",
          blockCidr.getRiskLevel(), blockCidr.getBlockCidr(), blockCidr.getExpirationDate(), blockCidr.getNote(),
          blockCidr.getNo()));
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }
}