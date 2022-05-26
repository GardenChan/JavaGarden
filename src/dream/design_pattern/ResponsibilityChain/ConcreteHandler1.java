package dream.design_pattern.ResponsibilityChain;

/**
 * projectName:java-garden
 * see:dream.design_pattern.ResponsibilityChain
 * createTime:2021/9/21 10:17
 * author: Jiading chen
 * description:
 */
public class ConcreteHandler1 extends Handler {

    public ConcreteHandler1(Handler successor) {
        super(successor);
    }

    @Override
    protected void handleRequest(Request request) {
        if (request.getType() == RequestType.type1) {
            System.out.println(request.getName() + " is handler by concreteHandler1");
            return;
        }
        if (successor!= null) {
            successor.handleRequest(request);
        }
    }

}
