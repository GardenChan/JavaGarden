package dream.design_pattern.singleton;

/**
 * @author GardenChan
 * @create 2021-09-02 19:45
 * 懒汉式-线程安全
 */
public class Singleton2 {
    private static Singleton2 uniqueInstance;
    private Singleton2(){
    }
    public static synchronized Singleton2 getUniqueInstance(){
        if (uniqueInstance==null){
            uniqueInstance = new Singleton2();
        }
        return uniqueInstance;
    }
}
