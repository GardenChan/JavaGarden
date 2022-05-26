package dream.design_pattern.ResponsibilityChain;

/**
 * projectName:java-garden
 * see:dream.design_pattern.ResponsibilityChain
 * createTime:2021/9/21 10:14
 * author: Jiading chen
 * description:
 */
public class Request {
    private RequestType type;
    private String name;

    public Request(RequestType type, String name) {
        this.type = type;
        this.name = name;
    }

    public RequestType getType(){
        return type;
    }
    public String getName(){
        return name;
    }
}
