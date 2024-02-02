package com.pjs.wafapp.dao.mysql;

import com.pjs.wafapp.dao.BlockFqdnDao;
import com.pjs.wafapp.dao.DaoException;
import com.pjs.wafapp.vo.BlockFqdn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BlockFqdnDaoImpl implements BlockFqdnDao {

  Connection con;

  public BlockFqdnDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(BlockFqdn blockFqdn) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(String.format(
          "insert into fqdn_block_pol(risk_level,block_url,sub_dir,expiration_date,note) values('%s','%s','%s','%s','%s')",
          blockFqdn.getRiskLevel(), blockFqdn.getBlockUrl(), blockFqdn.getSubDirectory(), blockFqdn.getExpirationDate(), blockFqdn.getNote()));

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(
          String.format("delete from fqdn_block_pol where fqdn_pol_no=%d", no));
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public List<BlockFqdn> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from fqdn_block_pol");

      ArrayList<BlockFqdn> list = new ArrayList<>();

      while (rs.next()) {
        BlockFqdn blockFqdn = new BlockFqdn();
        blockFqdn.setNo(rs.getInt("fqdn_pol_no"));
        blockFqdn.setRiskLevel(rs.getString("risk_level"));
        blockFqdn.setBlockUrl(rs.getString("block_url"));
        blockFqdn.setSubDirectory(rs.getString("sub_dir"));
        blockFqdn.setExpirationDate(rs.getDate("expiration_date"));
        blockFqdn.setNote(rs.getString("note"));

        list.add(blockFqdn);
      }
      return list;
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public BlockFqdn findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from fqdn_block_pol where fqdn_pol_no = " + no);

      if (rs.next()) {
        BlockFqdn blockFqdn = new BlockFqdn();
        blockFqdn.setNo(rs.getInt("fqdn_pol_no"));
        blockFqdn.setRiskLevel(rs.getString("risk_level"));
        blockFqdn.setBlockUrl(rs.getString("block_url"));
        blockFqdn.setSubDirectory(rs.getString("sub_dir"));
        blockFqdn.setExpirationDate(rs.getDate("expiration_date"));
        blockFqdn.setNote(rs.getString("note"));

        return blockFqdn;
      }
      return null;
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(BlockFqdn blockFqdn) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
          "update fqdn_block_pol set risk_level='%s', block_url='%s', sub_dir='%s',expiration_date='%s', note='%s' where fqdn_pol_no=%d",
          blockFqdn.getRiskLevel(), blockFqdn.getBlockUrl(), blockFqdn.getSubDirectory(), blockFqdn.getExpirationDate(), blockFqdn.getNote(),
          blockFqdn.getNo()));
    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }
}