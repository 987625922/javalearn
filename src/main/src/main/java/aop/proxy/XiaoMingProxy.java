package aop.proxy;

import aop.bean.XiaoMing;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class XiaoMingProxy {
    XiaoMing xiaoMing = new XiaoMing();

    //反射bean
    public Person getProxy() {
        return (Person) Proxy.newProxyInstance(XiaoMingProxy.class.getClassLoader(),
                xiaoMing.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("sing")) {

                            System.out.println("给1000万来再唱");

                            //实际上唱歌的还是小明
                            method.invoke(xiaoMing, args);
                        }
                        return null;
                    }
                });
    }
}