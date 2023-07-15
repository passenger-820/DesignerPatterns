package creational.factory.simpleFactory;

// 这里的if-else依旧是hard coding，所以只适用于业务简单的场景
public class ResourceFactory {
    /**
     * 创建资源
     * @param type url的prefix
     * @param url 资源地址
     * @return 资源
     */
    public static Resource create(String type,String url){
        if("http".equals(type)){
            // ..发起请求下载资源... 可能很复杂
            return new Resource(url);
        } else if ("file".equals(type)) {
            // ..建立流，做异常处理等等
            return new Resource(url);
        } else if ("classpath".equals(type)) {
            // ...
            return new Resource(url);
        }
        return new Resource("default");
    }
}
