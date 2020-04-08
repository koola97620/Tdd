package chapter7;

/**
 * @author choijaeyong on 2020/04/08.
 * @project tdd2
 * @description
 */
public class StubWeakPasswordChecker implements WeakPasswordChecker{
  private boolean weak;

  public void setWeak(boolean weak) {
    this.weak = weak;
  }

  @Override
  public boolean checkPasswordWeak(String pw) {
    return weak;
  }
}
