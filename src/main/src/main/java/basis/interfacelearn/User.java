package basis.interfacelearn;

/**
 * 接口内实体方法
 */
public class User implements Person, PersonTwo {

    @Override
    public void getName() {
        PersonTwo.super.getName();
        System.out.println("user");
    }
}