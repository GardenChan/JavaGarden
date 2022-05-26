package dream.design_pattern.SimpleFactory;

/**
 * projectName:java-garden
 * see:dream.design_pattern.SimpleFactory
 * createTime:2021/9/21 11:04
 * author: Jiading chen
 * description:
 */
public class Client {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(1);
    }
}
