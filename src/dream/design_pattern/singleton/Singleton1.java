package dream.design_pattern.singleton;

/**
 * @author GardenChan
 * @create 2021-09-02 19:41
 * 懒汉式-线程不安全
 */
public class Singleton1 {
    private static Singleton1 uniqueInstance;
    private Singleton1(){}
    public static Singleton1 getUniqueInstance(){
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton1();
        }
        return uniqueInstance;
    }
}
