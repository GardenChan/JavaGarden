package dream.design_pattern.ResponsibilityChain;

/**
 * projectName:java-garden
 * see:dream.design_pattern.ResponsibilityChain
 * createTime:2021/9/21 10:13
 * author: Jiading chen
 * description:
 */
public abstract class Handler {
    protected Handler successor;

    public Handler(Handler successor) {
        this.successor = successor;
    }

    protected abstract void handleRequest(Request request);
}
