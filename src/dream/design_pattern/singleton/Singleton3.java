package dream.design_pattern.singleton;

/**
 * @author GardenChan
 * @create 2021-09-02 19:47
 * 饿汉式-线程安全
 */
public class Singleton3 {
    private static Singleton3 uniqueInstance = new Singleton3();
    private Singleton3(){}
    public static Singleton3 getUniqueInstance(){
        return uniqueInstance;
    }
}
