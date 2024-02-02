package com.pjs.wafapp.dao;

import com.pjs.wafapp.vo.BlockFqdn;
import java.util.List;

public interface BlockFqdnDao {

  void add(BlockFqdn blockFqdn);

  int delete(int no);

  List<BlockFqdn> findAll();

  BlockFqdn findBy(int no);

  int update(BlockFqdn blockFqdn);

}
