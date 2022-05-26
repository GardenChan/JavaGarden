package dream.design_pattern.FactoryMethod;

import dream.design_pattern.SimpleFactory.ConcreteProduct1;
import dream.design_pattern.SimpleFactory.Product;

/**
 * projectName:java-garden
 * see:dream.design_pattern.FactoryMethod
 * createTime:2021/9/21 11:09
 * author: Jiading chen
 * description:
 */
public class ConcreteFactory1 extends Factory {
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct1();
    }
}
