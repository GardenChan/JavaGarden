package dream.design_pattern.Observer;

/**
 * projectName:java-garden
 * see:dream.design_pattern.Observer
 * createTime:2021/9/21 10:57
 * author: Jiading chen
 * description:
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

        weatherData.setMeasurements(0, 0, 0);
        weatherData.setMeasurements(1, 1, 1);
    }
}
