package dream.design_pattern.AbstractFactory;

/**
 * projectName:java-garden
 * see:dream.design_pattern.AbstractFactory
 * createTime:2021/9/21 11:20
 * author: Jiading chen
 * description:
 */
public class ConcreteFactory2 extends AbstractFactory {
    @Override
    AbstractA createProductA() {
        return new ProductA2();
    }

    @Override
    AbstractB createProductB() {
        return new ProductB2();
    }
}
