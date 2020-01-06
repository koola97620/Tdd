/**
 * @author choijaeyong on 2020/01/06.
 * @project effective-unit-testing
 * @description
 */
public class Car {
  private Engine engine;

  public Car(Engine engine) {
    this.engine = engine;
  }

  public void start() {
    engine.start();
  }

  public void drive(Route route) {
    for (Directions directions : route.directions() ) {
      directions.follow();
    }
  }

  public void stop() {
    engine.stop();
  }
}
