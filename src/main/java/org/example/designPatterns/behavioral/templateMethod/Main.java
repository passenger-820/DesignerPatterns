package org.example.designPatterns.behavioral.templateMethod;

public class Main {
    public static void main(String[] args) {
        AbstractTemplate concreteTemplateA = new ConcreteTemplateA();
        AbstractTemplate concreteTemplateB = new ConcreteTemplateB();

        System.out.println("Using Template A:");
        concreteTemplateA.templateMethod();
        System.out.println("Using Template B:");
        concreteTemplateB.templateMethod();
    }
}
