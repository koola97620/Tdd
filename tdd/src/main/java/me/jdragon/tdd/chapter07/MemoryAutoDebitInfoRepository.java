package me.jdragon.tdd.chapter07;

import java.util.HashMap;
import java.util.Map;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public class MemoryAutoDebitInfoRepository implements AutoDebitInfoRepository {
  private Map<String, AutoDebitInfo> infos = new HashMap<>();

  @Override
  public AutoDebitInfo findOne(String userId) {
    return infos.get(userId);
  }

  @Override
  public void save(AutoDebitInfo info) {
    infos.put(info.getUserId() , info);
  }
}
