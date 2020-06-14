package basis.optional;

import common.bean.User;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Simple {

    public static void main(String[] args) throws Throwable {
        Optional<User> optionalUser = Optional.ofNullable(null);
        //获取真实的值，如果没有值就抛出异常
        optionalUser.get();
        //获取真实值是否为空
        boolean ispresent = optionalUser.isPresent();
        //如果真实bean不是空就会调用accept方法,是空就不会调用
        optionalUser.ifPresent(new Consumer<User>() {
            @Override
            public void accept(User user) {

            }
        });
        //如果真实bean不为空就返回真实bean(并且会运行orElse里面的方法)，否则返回orElse传入的值
        User elseUser = optionalUser.orElse(new User());
        //如果真实bean不为空就返回真实bean(不会运行get()方法，更加节省性能)，如果为空就运行get()方法
        User elseGetUser = optionalUser.orElseGet(new Supplier<User>() {
            @Override
            public User get() {
                return new User();
            }
        });
        //如果真实bean为空就会抛出异常
        User uthrowUser = optionalUser.orElseThrow(new Supplier<Throwable>() {
            @Override
            public Throwable get() {
                return new RuntimeException();
            }
        });
        //转换Optional<User>为Optional<Object>
        Optional<String> mapUser = optionalUser.map(new Function<User, String>() {
            @Override
            public String apply(User user) {
                user.getUserName();
                return "把user转换成String";
            }
        });
        //研究
//        Optional<String>  = optionalUser.flatMap(new Function<User, Optional<? extends Object>>() {
//            @Override
//            public Optional<? extends Object> apply(User user) {
//                return Optional.empty();
//            }
//        })

    }

}
