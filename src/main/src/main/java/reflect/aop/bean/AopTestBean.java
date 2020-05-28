package reflect.aop.bean;

import reflect.aop.proxy.AopTestInterface;

public class AopTestBean implements AopTestInterface {
    @Override
    public void dance(String str) {
        System.out.println(str);
    }

    @Override
    public void sing(String str) {
        System.out.println("AopTestBean的本体方法：" + str);
    }
}
