package dream.design_pattern.ResponsibilityChain;

/**
 * projectName:java-garden
 * see:dream.design_pattern.ResponsibilityChain
 * createTime:2021/9/21 10:20
 * author: Jiading chen
 * description:
 */
public class ConcreteHandler2 extends Handler {
    public ConcreteHandler2(Handler successor) {
        super(successor);
    }

    @Override
    protected void handleRequest(Request request) {
        if (request.getType() == RequestType.type2) {
            System.out.println(request.getName() + " is handle by ConcreteHandler2");
            return;
        }
        if (successor != null) {
            successor.handleRequest(request);
        }
    }
}
