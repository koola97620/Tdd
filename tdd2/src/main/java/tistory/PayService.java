package tistory;

import java.nio.file.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author choijaeyong on 2020/04/01.
 * @project tdd2
 * @description
 */

@Service
public class PayService {

  @Autowired
  private PayRepostiroy payRepostiroy;

  public PayService() {

  }

  public PayService(PayRepostiroy payRepostiroy) {

  }

  public void savePayResult(Path filePath) {
    PayService payService = new PayService(payRepostiroy);

  }
}
