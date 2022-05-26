package dream.design_pattern.AbstractFactory;

/**
 * projectName:java-garden
 * see:dream.design_pattern.AbstractFactory
 * createTime:2021/9/21 11:21
 * author: Jiading chen
 * description:
 */
public class Client {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new ConcreteFactory1();
        AbstractA productA = abstractFactory.createProductA();
        AbstractB productB = abstractFactory.createProductB();
        // do something with productA and productB
    }
}
