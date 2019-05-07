import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author choijaeyong on 07/05/2019.
 * @project tddExamSpringCamp
 * @description
 */
public class testTest {



  @Test
  public void nomatch() {
    Game game = new Game(479);

    Score s = game.guess(123);

    assertThat(s.strikes() , is(0));
    assertThat(s.balls() , is(0));

  }

  private class Game {
    public Game(int value) {
    }

    public Score guess(int value) {
      return Score.create(0,0);
    }

  }

  public static class Score {
    private int scnt;
    private int bcnt;

    public Score() {
    }

    public int strikes() {
      return scnt;
    }
    public int balls() {
      return bcnt;
    }
    public static Score create(int value1, int value2) {
      return new Score();
    }


  }
}