package dream.design_pattern.singleton;

/**
 * @author GardenChan
 * @create 2021-09-02 19:52
 * 静态内部类实现
 */
public class Singleton5 {
    private Singleton5(){}
    private static class SingletonHolder{
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    public static Singleton5 getUniqueInstance(){
        return SingletonHolder.INSTANCE;
    }
}
