package org.example.designPatterns.structural.decorator;

public class Main {
    public static void main(String[] args) {
        //被包装对象
        Component component = new ConcreteComponent();
        //第一层包装，包装完自己也还是被包装对象
        component = new ConcreteDecoratorA(component);
        component = new ConcreteDecoratorB(component);
        component.operation();
        /*
        [第二层包装的operation()：
            前置行为：ConcreteDecoratorB is adding new behavior1...
            [第一层包装的operation()：
                前置行为：ConcreteDecoratorA is adding new behavior1...
                [原始component的operation()：ConcreteComponent is doing something...]
                后置行为：ConcreteDecoratorA is adding new behavior2...
            ]
            后置行为：ConcreteDecoratorB is adding new behavior2...
        ]
         */
    }

}
