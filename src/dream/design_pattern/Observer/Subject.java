package dream.design_pattern.Observer;

/**
 * projectName:java-garden
 * see:dream.design_pattern.Observer
 * createTime:2021/9/21 10:45
 * author: Jiading chen
 * description:
 */
public interface Subject {
    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObserver();
}
