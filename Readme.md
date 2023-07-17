# 设计模式

## 1. 创建型

### 1.1 单例
1. 私有化构造器
2. 暴露一个获取实例方法
3. 考虑是否支持懒加载，是否线程安全
* 饿汉
  * 非懒加载，线程安全有JVM实现
* 懒汉
  * 懒加载，线程不安全
* 双重检查锁
  * 懒加载，线程安全
* 静态内部类
  * 懒加载，类的静态常量因而线程安全
* 枚举
  * 天然单例，本质静态常量
#### 存在的问题
* 反射入侵
  * 构造器里加个判空
* 序列化与反序列化
  * readResolve()方法

### 1.2 工厂
* 简单工厂
  * 单个工厂，根据条件，生产对应产品
* 抽象工厂
  * 工厂被抽象，需要生产商品时，实现对应的工厂
* 工厂方法
  * 产品也抽象，工厂也抽象，且单个工厂可以生产产品族
  * 生产产品分别去实现具体产品和具体工厂

### 1.3 建造者
* 标准流程
  * 产品+抽象建造者+具体建造者+指挥者
* 内部类
  * 抽象建造者移除，具体建造者成为静态内部类，持有外部的产品类，同时能够设置其属性
* 不可变对象（基于内部类Builder）
  * 私有化构造函数，让外界无法直接通过ImmutablePerson类来构建，构造器传入的为Builder。
  * 通过 Builder 类的方法来设置属性值，可以选择性地设置需要的属性，而不需要在构造函数中传递一堆参数。这样可以更灵活地构建对象，并且只设置感兴趣的属性。 
  * 如果在构建 ImmutablePerson 对象时不一次性给外部类的属性赋值，可能会导致 ImmutablePerson 对象处于不完整或不一致的状态。【对象处于无效状态】

### 1.4 原型
* 浅拷贝
  * 只拷贝一层，可以直接赋值，也可以clone
* 深拷贝
  * 递归克隆：对于非基础类型，需要额外拷贝再赋值走
  * 序列化：使用对象，对原型对象进行序列化， 再对序列化后的二进制流执行反序列化操作，就可以得到一个完完全全相同的新对象。

## 2. 结构型

### 2.1 代理
为其他对象提供一个代理，以控制对这个对象的访问。
* 静态代理，代理类在编译时就已经确定
  * 核心就是持有被代理对象，可以实现它的功能，以控制该对象，并额外提供一些功能
* 动态代理，代理类在运行时动态生成，更方便写代码，也用得多
  * JDK
    * **定义一个接口，声明需要代理的方法**
    * **创建一个被代理类，实现这个接口，并在其中定义实现方法**
    * **创建一个代理类，实现 `InvocationHandler` 接口，并在其中定义一个被代理类的对象作为属性**，有三个核心参数
      * classLoader：被代理类的类加载器
      * 代理类需要实现的接口数组 Class[]
      * InvocationHandler
    * **在使用代理类时，创建被代理类的对象和代理类的对象，并使用 `Proxy.newProxyInstance` 方法生成代理对象**
  * CGLIB
    * **创建一个被代理类，定义需要被代理的方法**
    * **创建一个方法拦截器类，实现 `MethodInterceptor` 接口，并在其中定义一个被代理类的对象作为属性**
    * **在使用代理类时，创建被代理类的对象和代理类的对象，并使用 `Enhancer.create` 方法生成代理对象**
    * 基于 CGLIB 的动态代理需要使用 `net.sf.cglib.proxy.Enhancer` 类和 `net.sf.cglib.proxy.MethodInterceptor` 接口
  * aop，使用 Spring AOP，可以在程序运行时动态地将代码织入到目标对象中，从而实现对目标对象的增强，代理和 AOP 是两个相关的概念，代理是 AOP 的一种实现方式
    * 开启自动代理@EnableAspectJAutoProxy
    * 定义接口和实现类，并将具体实现注入容器
    * 定义切面类，对方法做增强
AOP基础知识补充
1. `Aspect（切面，即2，3，4）`：**一个关注点的模块化，这个关注点可能会横切多个对象**。事务管理是J2EE应用中一个关于横切，关注点的很好的例子。，
2. `Join point（连接点 ）`：在程序执行过程中某个特定的点，比如某方法调用的时候或者处理异常的时候。**举个例子，对一个方法增强，前后都可以插入内容，还比如抛异常，执行返回前，这些都是连接点。**
3. `Advice（通知）`：在切面的某个特定的连接点（Joinpoint）上执行的动作。通知有各种类型，其中包括“around”、“before”和“after”等通知。 通知的类型将在后面部分进行讨论。许多AOP框架，包括Spring，都是以拦截器做通知模型， 并维护一个以连接点为中心的拦截器链。**大白话，插入的这些代码都是通知。**
4. `Pointcut（切入点 ）`：匹配连接点（Joinpoint）的断言。**【通知】和一个【切入点表达式】关联，并在满足这个切入点的连接点上运行。（切点表达式用于确定切入的连接点）** 【切入点表达式如何和连接点匹配】是AOP的核心：Spring缺省使用AspectJ切入点语法。**说简单点，切入点是连接点的子集，连接点是所有可以插入内容的地方，而真正有内容插入后，那个连接点就是切入点。**
5. `Introduction（引入）`： Spring**允许引入新的接口（以及一个对应的实现）到任何被代理的对象（让代理额外再实现新的接口）**。例如，你可以使用一个引入来使bean实现 IsModified 接口，以便简化缓存机制。
6. `Target object（目标对象）`：**被一个或者多个切面（aspect）所通知（advise）的对象**。也有人把它叫做 **被通知（advised） 对象**。 既然Spring AOP是通过运行时代理实现的，这个对象永远是一个 被代理（proxied） 对象。
7. `AOP proxy`： 在Spring中，**AOP代理可以是JDK动态代理（兄弟）或者CGLIB代理（父子）**。
8. `Weaving（织入）`：**把切面（aspect）连接到其它的应用程序类型或者对象上，并创建一个被通知（advised）的对象，这个【过程】叫织入。说简单点，就是把通知放在连接点上的过程。** 这些可以在编译时（例如使用AspectJ编译器），类加载时和运行时完成。 Spring和其他纯Java AOP框架一样，在运行时完成织入。

> Spring AOP包括以下类型的通知:

- `Before advice` :在连接点之前运行的通知，但不能阻止执行流继续执行到连接点(除非它抛出异常)。
- `After returning advice` :在连接点正常完成后运行的通知(例如，如果方法返回而不引发异常)。
- `After throwing advice`:在方法通过抛出异常退出时运行的通知。
- `After (finally) advice`:不管连接点以何种方式退出(正常或异常返回)，都要运行的通知。
- `Around advice`:围绕连接点(如方法调用)的通知。 这是最有力的建议。 Around通知可以在方法调用前后执行自定义行为。 它还负责选择是继续到连接点，还是通过返回自己的返回值或抛出异常来简化被通知的方法执行。

### 2.2 装饰器
动态地为对象添加新的行为。将对象放入一个装饰器类中，再将装饰器类放入另一个装饰器类中，以此类推，形成一条**包装链**。这样，可以在**不改变原有对象**的情况下，**动态地添加新的行为或修改原有行为**。

1. 接口或抽象类，作为被装饰对象的**基类**
2. 具体的被装饰对象
3. 抽象装饰器类，**继承基类**(装饰器和被装饰对象同源)，并将被装饰对象作为属性（套娃）
4. 具体的装饰器类，继承抽象装饰器类，并实现增强逻辑
5. 使用装饰器增强被装饰对象

### 2.3 适配器
用于**解决两个不兼容接口之间的问题**。适配器允许**将一个类的接口转换为客户端期望的另一个接口，使得原本由于接口不兼容而不能一起工作的类可以一起工作。**
主要包含以下四个角色：

1. **目标接口（Target）**：客户端期望使用的接口，它定义了特定领域的操作和方法。
2. **需要适配的类（Adaptee）**：已存在的类，它具有客户端需要的功能，但其接口与目标接口不兼容。适配器的目标是使这个类的功能能够通过目标接口使用。
3. **适配器（Adapter）**：适配器模式的核心角色，它实现了目标接口并持有需要适配的类的一个实例。适配器通过封装Adaptee的功能，使其能够满足Target接口的要求。
4. **客户端（Client）**：使用目标接口的类。客户端与目标接口进行交互，不直接与需要适配的类交互。通过使用适配器，客户端可以间接地使用需要适配的类的功能。

适配器模式有两种实现方式：**类**适配器【基于继承】和**对象**适配器【基于组合】。


## 3. 行为型
### 3.1 观察者
允许对象间存在**一对多的依赖关系**，当**一个对象的状态发生改变时，所有依赖它的对象都会得到通知并自动更新**。在这种模式中，**发生状态改变的对象被称为“主题”（Subject），依赖它的对象被称为“观察者”（Observer）。**

**观察者模式**也被称为**发布订阅模式**。

* 传统观察者
  * 主题+具体主题，当发生改变时，应当通知所有观察该变化的观测者
  * 抽象观察者+具体观察者，将自己注册到具体主题，实现对观察内容的监听与反应
* 发布-订阅
  * 引入了一个第三方组件（通常称为消息代理或事件总线）该组件负责维护发布者和订阅者之间的关系。这意味着**发布者和订阅者彼此不直接通信**，而是**通过消息代理进行通信**。这种间接通信**允许发布者和订阅者在运行时动态地添加或删除**，从而提高了系统的灵活性和可扩展性。**【说白了，中间加一层，让发布者和订阅者解耦】**
  * 事件总线，可以根据事件类型eventType，将订阅者注册或删除到对应的订阅者集合，同时可以向某一eventType发布事件
  * 发布者持有事件总线，可以向总线的某个eventType发送具体事件eventContext
  * 订阅者根据eventType，对eventContext做出反应

#### 补充知识：箭头函数
如果**一个接口只有一个抽象方法**，那么这个接口也称之为**函数式接口**。可以使用@FunctionalInterface注解标识。

```java
@FunctionalInterface
public interface Function {
    int plus(int i,int j);
}
```

**使用函数式接口去构造内部类**时，很简单的表示：

```java
public class Client {

    /**
     * 这个类能计算加法
     * @param function
     */
    public static void test(Function function){
        System.out.println(function.plus(1, 2));
    }

    public static void main(String[] args) {
        // 这里我们使用了内部类
        test(new Function() {
            @Override
            public int plus(int i, int j) {
                return i + j;
            }
        });
    }
}
```

可以对之进行简化

1、**类名方法名全不要**，这个结构分为两部分，**第一部分，小括号包裹形参，类型也不要、第二部分 【->】、第三部分是方法体**：

```java
 public static void main(String[] args) {
        // 这里我们使用了内部类
        test((i,j) -> {return i + j;});
    }
```

2、**方法体如果只用一行代码，大括号可以省略，如果一行代码是返回值，return可以省略。**

```java
 public static void main(String[] args) {
        // 这里我们使用了内部类
        test((i,j) -> i + j);
    }
```

### 3.2 模板方法
模板方法模式在一个方法中定义一个**算法骨架**，并将某些步骤**推迟到子类中实现**。模板方法模式可以让子类在不改变算法整体结构的情况下，**重新定义算法中的某些步骤**。

**这里的“算法”，可以理解为广义上的“业务逻辑”，并不特指数据结构和算法中的“算法”**。这里的算法骨架就是“模板”，包含算法骨架的方法就是“模板方法”，这也是模板方法模式名字的由来。

模板模式有两大作用：**【复用】和【扩展】**。

大白话，我规定了流程，我自己完成一部分【复用】，给别人留点发挥空间【扩展】

* 创建一个抽象类，定义算法的骨架
* 创建具体的子类，实现抽象类中定义的抽象方法
* 在客户端代码中使用模板方法

#### 回调
**二者的区别**：
1. **设计范式**：模板方法设计模式通常用于面向对象编程（OOP），它依赖于继承和多态来实现代码复用。**回调函数则通常用于函数式编程，它通过将函数作为参数传递给其他函数来实现代码复用**。
2. **实现方式**：模板方法设计模式依赖于抽象类和子类之间的继承关系。在抽象类中定义一个算法的骨架，并将某些步骤延迟到子类中实现。而回调函数通过将一个函数作为参数传递给另一个函数，让调用者可以自定义特定的行为。

**二者的联系**：

1. **目的**：模板方法设计模式和回调函数都旨在将变化的部分与不变的部分分离，提高代码的复用性和可维护性。
2. **实现相互关系**：在某些情况下，模板方法设计模式可以通过回调函数来实现。例如，**在Java中，可以使用匿名内部类或者Lambda表达式作为回调函数，实现模板方法设计模式的目标**。类似地，在面向对象的语言中，回调函数也可以通过模板方法设计模式来实现。

A 类事先注册某个函数 F 到 B 类，A 类再调用 B 类的 P 函数的时候，B 类反过来调用 A 类注册给它的 F 函数。
这里的 F 函数就是“回调函数”。A 调用 B，B 反过来又调用 A，这种调用机制就叫作“回调”。

A 类如何将回调函数传递给 B 类呢？不同的编程语言，有不同的实现方法。
Java 则需要使用包裹了回调函数的类对象，我们简称为回调对象。

回调可以分为**同步回调**和**异步回调（或者延迟回调）**。
同步回调指在函数返回之前执行回调函数；异步回调指的是在函数返回之后执行回调函数。
GitHub库中的代码实际上是同步回调的实现方式，在 process() 函数返回之前，执行完回调函数 methodToCallback()。
**从应用场景上来看，同步回调看起来更像模板模式，异步回调看起来更像观察者模式。**

### 3.3 策略
TODO


### 3.4 责任链
TODO

