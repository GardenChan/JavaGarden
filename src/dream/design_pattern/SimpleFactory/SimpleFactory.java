package dream.design_pattern.SimpleFactory;

/**
 * projectName:java-garden
 * see:dream.design_pattern.SimpleFactory
 * createTime:2021/9/21 11:03
 * author: Jiading chen
 * description:
 */
public class SimpleFactory {
    public Product createProduct(int type){
        if (type == 1) {
            return new ConcreteProduct1();
        } else {
            return new ConcreteProduct2();
        }
    }
}
