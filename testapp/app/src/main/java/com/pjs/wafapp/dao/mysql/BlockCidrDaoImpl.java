package com.pjs.wafapp.dao.mysql;

import com.pjs.wafapp.dao.BlockCidrDao;
import com.pjs.wafapp.dao.DaoException;
import com.pjs.wafapp.vo.BlockCidr;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    try (PreparedStatement pstmt = con.prepareStatement(
        "insert into cidr_block_pol(risk_level,block_cidr,web_ip,expiration_date,note) values(?,?,?,?,?)")) {
      pstmt.setInt(1,blockCidr.getNo());
      pstmt.setString(2,blockCidr.getBlockCidr());
      pstmt.setString(3, blockCidr.getWebIp());
      pstmt.setDate(4,blockCidr.getExpirationDate());
      pstmt.setString(5,blockCidr.getNote());

      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "delete from cidr_block_pol where cidr_pol_no=?")) {
      pstmt.setInt(1,no);

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public List<BlockCidr> findAll() {
    try ( PreparedStatement pstmt = con.prepareStatement(
        "select cbp.cidr_pol_no, cbp.risk_level, cbp.block_cidr, cbp.expiration_date, ws.hostname, cbp.note\n"
            + "  from cidr_block_pol cbp\n"
            + "  join web_server ws on cbp.web_ip=ws.web_ip")) {

      try (ResultSet rs = pstmt.executeQuery();) {

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
      }
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public BlockCidr findBy(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select * from cidr_block_pol where cidr_pol_no = ?")) {
     pstmt.setInt(1, no);

     try (ResultSet rs = pstmt.executeQuery()) {

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
     }
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(BlockCidr blockCidr) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "update cidr_block_pol set risk_level=?, block_cidr=?, web_ip=?,expiration_date=?, "
            + "note=? where cidr_pol_no=?")) {

        pstmt.setString(1,blockCidr.getRiskLevel());
        pstmt.setString(2,blockCidr.getBlockCidr());
      pstmt.setString(3,blockCidr.getWebIp());
      pstmt.setDate(4,blockCidr.getExpirationDate());
      pstmt.setString(5,blockCidr.getNote());
        pstmt.setInt(6,blockCidr.getNo());

      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }
}