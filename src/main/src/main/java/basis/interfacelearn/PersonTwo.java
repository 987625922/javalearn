package basis.interfacelearn;

public interface PersonTwo {
    default void getName() {
        System.out.println("persontwo");
    }
}
