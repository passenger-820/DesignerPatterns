package org.example.designPatterns.structural.adapter.classAdapter;

public class Main {
    public static void main(String[] args) {
        //面向接口编程，别写ClassAdapter classAdapter = new ClassAdapter();
        Target target = new ClassAdapter();
        target.request();
    }
}
