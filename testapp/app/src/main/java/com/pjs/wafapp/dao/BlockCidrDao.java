package com.pjs.wafapp.dao;

import com.pjs.wafapp.vo.BlockCidr;
import java.util.List;

public interface BlockCidrDao {

  void add(BlockCidr blockCidr);

  int delete(int no);

  List<BlockCidr> findAll();

  BlockCidr findBy(int no);

  int update(BlockCidr blockCidr);

}
