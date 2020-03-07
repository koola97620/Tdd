package me.jdragon.tdd.chapter07;

/**
 * @author choijaeyong on 2020/03/07.
 * @project tdd
 * @description
 */
public interface AutoDebitInfoRepository {

  AutoDebitInfo findOne(String userId);

  void save(AutoDebitInfo newInfo);
}
