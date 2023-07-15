package creational.builder.innerClass;

/**
 * 产品（Product）：表示将要被构建的复杂对象。
 */
public class HtmlDocument {
    private String header = "";
    private String body = "";
    private String footer = "";

    public void addHeader(String header) {
        this.header = header;
    }

    public void addBody(String body) {
        this.body = body;
    }

    public void addFooter(String footer) {
        this.footer = footer;
    }

    @Override
    public String toString() {
        return "<html><head>" + header + "</head><body>"
                + body + "</body><footer>" + footer + "</footer></html>";
    }

    /**
     * 这里使用静态内部类，让其持有外部的产品类，同时能够设置其属性
     * 这规避了抽象建造者，内部类直接作为具体建造者持有外部产品
     */
    public static class Builder{
        protected HtmlDocument document;

        public Builder(){
            document = new HtmlDocument();
        }

        //返回this这个静态内部类实例，从而可以一直 . 下去，构建产品将更加灵活
        public Builder addHeader(String header){
            document.addHeader(header);
            return this;
        }

        public Builder addBody(String body){
            document.addHeader(body);
            return this;
        }

        public Builder addFooter(String footer){
            document.addHeader(footer);
            return this;
        }

        //用于构建与返回产品
        public HtmlDocument build(){
            return document;
        }
    }
}
