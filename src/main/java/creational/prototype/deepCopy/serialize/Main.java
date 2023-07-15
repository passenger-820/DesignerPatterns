package creational.prototype.deepCopy.serialize;

import java.io.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {

    /*
    深拷贝的通用做法就是使用对象**对原型对象进行序列化，
    再对序列化后的二进制流执行反序列化操作，就可以得到一个完完全全相同的新对象，
    这种序列化的方式有很多比如先转为json，再转成内存模型的对象，也是可以的。
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建原始促销活动
        final PromotionEvent sourceEvent = createSamplePromotionEvent();

        //深拷贝
        //将对象转换为二进制流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); //字节数组输出流
        //将其与ByteArrayOutputStream关联起来，以便将对象序列化为字节流并写入ByteArrayOutputStream中。
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        //将sourceEvent对象序列化为字节流，并写入ByteArrayOutputStream中。
        oos.writeObject(sourceEvent);
        //将ByteArrayOutputStream中的字节数据转换为字节数组，以便后续操作
        byte[] bytes = outputStream.toByteArray();

        //使用字节流进行反序列化，得到一个实例
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
        PromotionEvent newEvent = (PromotionEvent) ois.readObject();

        // 测试
        System.out.println(sourceEvent == newEvent);
        System.out.println(
                newEvent.getRules().get(0).getProduct() ==
                        sourceEvent.getRules().get(0).getProduct()
        );
    }

    private static PromotionEvent createSamplePromotionEvent() {
        // 创建示例促销活动
        List<PromotionRule> rules = Arrays.asList(
                new PromotionRule("折扣", 0.9, new Product("ss",99,50012)),
                new PromotionRule("满减", 50, new Product("bb",99,40013))
        );

        PromotionEvent event = new PromotionEvent("原始促销活动", new Date(), addDays(new Date(), 7),
                rules
        );
        return event;
    }

    private static Date addDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }
}
