package org.example.designPatterns.structural.adapter.classAdapter;

/**
 * 要适配的类，即旧的类
 */
public class Adaptee {
    void oldRequest(){
        System.out.println("Adaptee's old request");
    }
}
