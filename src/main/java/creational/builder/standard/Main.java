package creational.builder.standard;

/**
 * 在工作中往往不会写的这么复杂，为了创建一个对象，我们创建了很多辅助的类，总觉得不太合适，在这个案例中，我们可以使用内部类来简化代码（甚至我们还移除了抽象层）
 */
public class Main {
    public static void main(String[] args) {

        ArticleHtmlDocumentBuilder builder = new ArticleHtmlDocumentBuilder();
        HtmlDirector director = new HtmlDirector(builder);
        director.buildHtmlDocument();
        HtmlDocument document = director.getDocument();
        System.out.println(document);
    }
}
