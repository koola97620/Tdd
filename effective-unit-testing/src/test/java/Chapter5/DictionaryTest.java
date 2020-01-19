package Chapter5;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;
import java.util.Map;
import org.junit.jupiter.api.Test;

/**
 * @author choijaeyong on 2020/01/19.
 * @project effective-unit-testing
 * @description
 */
class DictionaryTest {

  @Test
  public void returnAnIteratorForContents() {

    // 코드 모양만 기억하기 위해서 작성함.

    Dictionary dictionary = new Dictionary();
    dictionary.add("A" , new Long(3));
    dictionary.add("B","21");
    for (Iterator e = dictionary.iterator() ; e.hasNext();) {
      Map.Entry entry = (Map.Entry)e.next();
      if ("A".equals(entry.getKey())) {
        assertThat(entry.getKey()).isEqualTo(3L);
      }

      if ("B".equals(entry.getKey())) {
        assertThat(entry.getKey()).isEqualTo("21");
      }

    }
  }


}