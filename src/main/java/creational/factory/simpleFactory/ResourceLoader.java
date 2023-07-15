package creational.factory.simpleFactory;

public class ResourceLoader {
    /**
     * 加载资源
     * @param url 资源地址
     * @return 资源
     */
    public Resource load(String url){
        String type = getResourcePrefix(url);

//        // 这部分是没用简单工厂抽离
//        // 分支多，hard coding，可以把创建资源的能力交给工厂ResourceFactory
//        if("http".equals(type)){
//            // ..发起请求下载资源... 可能很复杂
//            return new Resource(url);
//        } else if ("file".equals(type)) {
//            // ..建立流，做异常处理等等
//            return new Resource(url);
//        } else if ("classpath".equals(type)) {
//            // ...
//            return new Resource(url);
//        }
//        return new Resource("default");

        //用了简单工厂则可以在此简化代码
        return ResourceFactory.create(type,url);
    }

    /**
     * 获取前缀
     * @param url 资源地址
     * @return 前缀
     */
    private String getResourcePrefix(String url){
        if (null == url || "".equals(url) || !url.contains(":")){
            throw new ResourceLoadException("url illegal");
        }
        String[] split = url.split(":");
        return split[0];
    }
}
