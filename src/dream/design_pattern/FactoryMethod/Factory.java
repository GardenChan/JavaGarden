package dream.design_pattern.FactoryMethod;

import dream.design_pattern.SimpleFactory.Product;

/**
 * projectName:java-garden
 * see:dream.design_pattern.FactoryMethod
 * createTime:2021/9/21 11:07
 * author: Jiading chen
 * description:
 */
public abstract class Factory {
    abstract public Product factoryMethod();
    public void doSomething(){
        Product product = factoryMethod();
        // do something with the product
    }
}
