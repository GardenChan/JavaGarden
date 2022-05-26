package dream.design_pattern.Strategy;

/**
 * projectName:java-garden
 * see:dream.design_pattern.Strategy
 * createTime:2021/9/21 11:25
 * author: Jiading chen
 * description:
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack!");
    }
}
