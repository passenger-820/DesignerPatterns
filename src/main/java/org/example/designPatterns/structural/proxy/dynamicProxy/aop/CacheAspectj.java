package org.example.designPatterns.structural.proxy.dynamicProxy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面类，对方法做增强
 * 1. `Aspect（切面，即2，3，4）`：一个关注点的模块化，这个关注点可能会横切多个对象。事务管理是J2EE应用中一个关于横切，关注点的很好的例子。，
 * 2. `Join point（连接点 ）`：在程序执行过程中某个特定的点，比如某方法调用的时候或者处理异常的时候。
 *      举个例子，对一个方法增强，前后都可以插入内容，还比如抛异常，执行返回前，这些都是连接点。
 * 3. `Advice（通知）`：在切面的某个特定的连接点（Joinpoint）上执行的动作。通知有各种类型，其中包括“around”、“before”和“after”等通知。
 *      通知的类型将在后面部分进行讨论。许多AOP框架，包括Spring，都是以拦截器做通知模型， 并维护一个以连接点为中心的拦截器链。大白话，插入的这些代码都是通知。
 * 4. `Pointcut（切入点 ）`：匹配连接点（Joinpoint）的断言。【通知】和一个【切入点表达式】关联，并在满足这个切入点的连接点上运行。
 *      （切点表达式用于确定切入的连接点）【切入点表达式如何和连接点匹配】是AOP的核心：Spring缺省使用AspectJ切入点语法。
 *      说简单点，切入点是连接点的子集，连接点是所有可以插入内容的地方，而真正有内容插入后，那个连接点就是切入点。
 * 在使用 Spring AOP 时，还需要注意
 *      如果目标对象实现了接口（无论是何接口），则默认使用 JDK 动态代理进行代理；
 *      如果目标对象没有实现接口，则使用 CGLIB 进行代理。
 *      如果想要强制使用 CGLIB 进行代理，可以在配置类中使用 `@EnableAspectJAutoProxy(proxyTargetClass = true)` 注解。
 */
@Component
@Aspect
public class CacheAspectj {
    /**
     * 定义切点，使用切点表达式匹配到连接点（程序执行到的某一时刻或状态）
     */
    @Pointcut("execution(* org.example.designPatterns.structural.proxy.dynamicProxy.aop.DatabaseDataQuery.query(..))")
    public void pointcut() {}

    /**
     * 定义通知
     * @param joinPoint 连接点，pointcut匹配到的query()方法
     * @return 具体结果
     */
    @Around("pointcut()")
    public String around(ProceedingJoinPoint joinPoint){
        //传入query中的参数 joinPoint.getArgs()
        Object[] args = joinPoint.getArgs();
        String key = args[0].toString();

        // 1、查询缓存，命中则返回
        String result = Cache.get(key);
        if(result !=  null){
            System.out.println("数据从缓存中获取");
            return result;
        }

        // 未命中则去数据库查询，实际上是调用被代理bean的方法
        try {
            //原路往后走 joinPoint.proceed()
            result = joinPoint.proceed().toString();
            // 如果查询有结果，进行缓存
            if (result != null){
                Cache.put(key,result);
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
