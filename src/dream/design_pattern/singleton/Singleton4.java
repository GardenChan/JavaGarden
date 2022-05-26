package dream.design_pattern.singleton;

/**
 * @author GardenChan
 * @create 2021-09-02 19:48
 * 双重校验锁-线程安全
 */
public class Singleton4 {
    private volatile static Singleton4 uniqueInstance;
    private Singleton4(){
    }

    public static Singleton4 getUniqueInstance(){
        if (uniqueInstance==null){
            synchronized (Singleton4.class){
                if (uniqueInstance==null){
                    uniqueInstance = new Singleton4();
                }
            }
        }
        return uniqueInstance;
    }
}
