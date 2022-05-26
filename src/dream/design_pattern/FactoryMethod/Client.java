package dream.design_pattern.FactoryMethod;

import dream.design_pattern.ResponsibilityChain.ConcreteHandler1;
import dream.design_pattern.SimpleFactory.Product;

/**
 * projectName:java-garden
 * see:dream.design_pattern.FactoryMethod
 * createTime:2021/9/21 11:10
 * author: Jiading chen
 * description:
 */
public class Client {
    public static void main(String[] args) {
        Factory factory1 = new ConcreteFactory1();
        Product product = factory1.factoryMethod();
    }
}
