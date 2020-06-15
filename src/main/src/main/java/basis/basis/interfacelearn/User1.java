package basis.basis.interfacelearn;

/**
 * 接口内实体方法
 */
public class User1 implements Person, PersonTwo {

    @Override
    public void getName() {
        PersonTwo.super.getName();
        System.out.println("user");
    }
}
