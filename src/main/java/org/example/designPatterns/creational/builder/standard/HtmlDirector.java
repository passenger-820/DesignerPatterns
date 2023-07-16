package org.example.designPatterns.creational.builder.standard;

/**
 * 指挥者（Director）：负责调用具体创建者来构建产品的各个部分，控制构建过程。
 * 我认为，整个构建者模式，就是让一个中间人持有产品，能够慢慢设置产品的熟悉，而不是让我们直接new产品和set属性
 * 指挥者就负责操作中间人，可以从他那拿到产品
 */
public class HtmlDirector {
    private HtmlDocumentBuilder builder;

    public HtmlDirector(HtmlDocumentBuilder builder){
        this.builder = builder;
    }

    public void buildHtmlDocument(){
        builder.createHtmlDocument();
        builder.addHeader();
        builder.addBody();
        builder.addFooter();
    }

    public HtmlDocument getDocument(){
        return builder.htmlDocument;
    }
}
