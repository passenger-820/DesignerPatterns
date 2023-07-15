package creational.builder.standard;

/**
 * 产品（Product）：表示将要被构建的复杂对象。
 */
public class HtmlDocument {
    private String header = "";
    private String body = "";
    private String footer = "";

    public void setHeader(String header) {
        this.header = header;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    @Override
    public String toString() {
        return "<html><head>" + header + "</head><body>"
                + body + "</body><footer>" + footer + "</footer></html>";
    }
}
