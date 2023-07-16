package org.example.designPatterns.creational.builder.standard;

/**
 * 抽象创建者（Abstract Builder）：定义构建产品的接口，通常包含创建和获取产品的方法。
 */
public abstract class HtmlDocumentBuilder {
    protected HtmlDocument htmlDocument;

    //创建产品
    public void createHtmlDocument(){
        htmlDocument = new HtmlDocument();
    }

    //获取产品
    public HtmlDocument getHtmlDocument(){
        return htmlDocument;
    }

    //一些抽象构建方法，交由子类实现
    public abstract void addHeader();
    public abstract void addBody();
    public abstract void addFooter();
}
