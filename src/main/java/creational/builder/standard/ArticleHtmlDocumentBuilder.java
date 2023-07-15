package creational.builder.standard;

/**
 *具体创建者（Concrete Builder）：实现抽象创建者定义的接口，为产品的各个部分提供具体实现。
 */
public class ArticleHtmlDocumentBuilder extends HtmlDocumentBuilder{
    @Override
    public void addHeader() {
        htmlDocument.setHeader("Article Header");
    }

    @Override
    public void addBody() {
        htmlDocument.setBody("Article Body");
    }

    @Override
    public void addFooter() {
        htmlDocument.setFooter("Article Footer");
    }

}
