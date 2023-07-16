package org.example.designPatterns.structural.adapter.objectAdapter;

public class Main {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new ObjectAdapter(adaptee);
        target.request();
    }
}
