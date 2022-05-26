package dream.design_pattern.Observer;

/**
 * projectName:java-garden
 * see:dream.design_pattern.Observer
 * createTime:2021/9/21 10:54
 * author: Jiading chen
 * description:
 */
public class StatisticsDisplay implements Observer {
    public StatisticsDisplay(Subject weatherData) {
        weatherData.registerObserver(this);
    }
    @Override
    public void update(float temp, float humidity, float pressure) {
        System.out.println("StatisticDisplay.update" + temp + " " + humidity + " " + pressure);
    }
}
