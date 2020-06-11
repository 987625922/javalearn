package basis.clone;

import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 深拷贝和浅拷贝是只针对Object和Array这样的引用数据类型的。
 * 浅拷贝只复制指向某个对象的指针，而不复制对象本身，新旧对象还是共享同一块内存。
 * 但深拷贝会另外创造一个一模一样的对象，新对象跟原对象不共享内存，修改新对象不会改到原对象。
 *
 * <p>
 * 浅拷贝的实现（实现Cloneable接口）
 * 拷贝后获取的是一个独立的对象，和原对象拥有不同的内存地址
 * 基本元素类型，两者是隔离的（虽然上面只给出了int，String）
 * 基本元素类型包括:
 * int, Integer, long, Long, char, Charset, byte,Byte, boolean, Boolean,
 * float,Float, double, Double, String
 * 非基本数据类型（如基本容器，其他对象等），只是拷贝了一份引用出去了，实际指向的依然是同一份
 *
 * <p>
 * 深拷贝（下面的deepClone方法），在浅拷贝的基础上，把类也new一个新的
 */
@Data
public class ShallowClone implements Cloneable {

    private String name;

    private int age;

    private List<String> books;


    public ShallowClone clone() {
        ShallowClone clone = null;
        try {
            clone = (ShallowClone) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    public ShallowClone deepClone() {
        ShallowClone clone = new ShallowClone();
        clone.name = this.name;
        clone.age = this.age;
        if (this.books != null) {
            clone.books = new ArrayList<>(this.books);
        }
        return clone;
    }

    @Test
    public void test() {
        ShallowClone shallowClone = new ShallowClone();
        shallowClone.setName("SourceName");
        shallowClone.setAge(28);
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("c++");
        shallowClone.setBooks(list);


        ShallowClone cloneObj = shallowClone.clone();


        // 判断两个对象是否为同一个对象（即是否是新创建了一个实例）
        System.out.println(shallowClone == cloneObj);

        // 修改一个对象的内容是否会影响另一个对象
        shallowClone.setName("newName");
        shallowClone.setAge(20);
        shallowClone.getBooks().add("javascript");
        System.out.println("source: " + shallowClone.toString() + "\nbasis.clone:" + cloneObj.toString());

        shallowClone.setBooks(Arrays.asList("hello"));
        System.out.println("source: " + shallowClone.toString() + "\nbasis.clone:" + cloneObj.toString());
    }

}
