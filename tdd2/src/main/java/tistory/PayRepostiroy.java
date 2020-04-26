package tistory;

import org.springframework.stereotype.Repository;

/**
 * @author choijaeyong on 2020/04/26.
 * @project tdd2
 * @description
 */

@Repository
public interface PayRepostiroy {
  PayInfo getPayInfo(long purchase_no);

}
