package dream.design_pattern.Strategy;

/**
 * projectName:java-garden
 * see:dream.design_pattern.Strategy
 * createTime:2021/9/21 11:26
 * author: Jiading chen
 * description:
 */
public class Duck {
    private QuackBehavior quackBehavior;

    public void performQuack(){
        if (quackBehavior != null) {
            quackBehavior.quack();
        }
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
