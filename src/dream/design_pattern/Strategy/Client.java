package dream.design_pattern.Strategy;

/**
 * projectName:java-garden
 * see:dream.design_pattern.Strategy
 * createTime:2021/9/21 11:28
 * author: Jiading chen
 * description:
 */
public class Client {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.setQuackBehavior(new Squeak());
        duck.performQuack();
        duck.setQuackBehavior(new Quack());
        duck.performQuack();
    }
}
