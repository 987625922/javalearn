package basis.basis.innerclass;

public class Main {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        /**
         * 内部类只有与外部类相关联的时候才能被创建
         */
        OuterClass.InnerClass innerClass = outerClass.getInnerClass();
        /**
         * 创建一个内部类
         */
        OuterClass.InnerClass innerClass1 = outerClass.new InnerClass();

//        OuterClass.PInnerClass innerClass2 = outerClass.new PInnerClass();
    }
}
