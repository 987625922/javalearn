package basis;

public interface PersonTwo {
    default void getName() {
        System.out.println("persontwo");
    }
}
