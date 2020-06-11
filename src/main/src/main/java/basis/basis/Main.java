package basis.basis;

import basis.interfacelearn.User;

import java.util.Optional;

/**
 * java基础的使用
 * 1.接口内实现方法
 * 2.可变参数String...
 * 3.Optional判空
 */
public class Main {

    public static void main(String[] args) {
        //接口内实体方法的使用
        User user = new User();
        user.getName();
        //可变参数的使用
        print("输出", "可变参数");
    }

    /**
     * 可变参数使用
     *
     * 即string。。。 out的使用
     */
    public static void print(String... out) {
        StringBuffer sb = new StringBuffer();
        for (String str : out) {
            sb.append(str);
        }
        System.out.println("可变参数使用：" + sb.toString());
    }

    /**
     * Optional判空
     */
    public static void optionalUse(){
        Optional<User> user = null;
        if (user.isPresent()){

        }else {

        }
    }
}
