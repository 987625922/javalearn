package basis.annotation.Repeatable;

import java.lang.annotation.*;

@Repeatable(Values.class)
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Value {

    String username() default "name";
    String phone() default "phone";

}
