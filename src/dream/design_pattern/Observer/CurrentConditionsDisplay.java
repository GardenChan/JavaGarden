package dream.design_pattern.Observer;

/**
 * projectName:java-garden
 * see:dream.design_pattern.Observer
 * createTime:2021/9/21 10:56
 * author: Jiading chen
 * description:
 */
public class CurrentConditionsDisplay implements Observer {
    public CurrentConditionsDisplay(Subject weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        System.out.println("CurrentConditionsDisplay.update: " + temp + " " + humidity + " " + pressure);
    }
}
