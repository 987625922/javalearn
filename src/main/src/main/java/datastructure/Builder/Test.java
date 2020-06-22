package datastructure.Builder;

public class Test {

    @org.junit.Test
    public void test() {
        BuilderModel build = BuilderModel.builder().name("zs").age(24).build();
    }
}
