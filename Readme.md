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

### 3.1 责任链
TODO
### 3.2 观察者
TODO
### 3.3 策略
TODO
### 3.4 模板方法
TODO