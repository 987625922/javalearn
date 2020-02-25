package basis.exception;

/**
 *      程序计数器是java虚拟机中唯一一块不会产生error的内存区域。
 *
 *                                                             丨-> StackOverFlowError(栈溢出)
 *                         --> VirtulMachineError(虚拟机错误异常)-
 *                        丨                                    丨-> OutOfMemoryError(内存溢出)
 *            丨-- Error->
 *            丨          丨
 *            丨           --> AWTError(用操作系统中的图形函数的抽象窗口工具，AWT组件出错)
 *            丨
 * Throwable-->
 *            丨                                                              丨-->EOFException(文件已结束异常)
 *            丨               --> IOException(操作输入流和输出流时可能出现的异常) -->
 *            丨              丨                                              丨-->FileNotFoundException(文件未找到异常)
 *            丨              丨
 *            丨-> Exception ->
 *                            丨
 *                            丨                       丨 --> ArrithmeticException(算术条件异常。譬如：整数除零等。)
 *                             --> RuntimeException -->
 *                                                     丨 --> MissingResourceException(缺少资源时抛出此异常)
 *                                                     丨
 *                                                     丨 --> ClassNotFoundException(找不到类异常。当应用试图根据字符串形式的类名构造类，
 *                                                                                  而在遍历CLASSPAH之后找不到对应名称的class文件时，抛出该异常。)
 *                                                     丨
 *                                                     丨 --> NullPointerException(空指针异常)
 *                                                     丨
 *                                                     丨 --> IllegalArgumentException(非法参数异常)
 *                                                     丨
 *                                                     丨 --> ArrayIndexOutOfBoundsException(数组索引越界异常)
 *                                                     丨
 *                                                     丨 --> UnKownTypeException(遇到未知种类的类型)
 */
public class ExceptionTest {

    public static void main(String args[]) {
        //整个流程就是正常的try catch走，而且2个finally都会走
        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch (Exception e) {
            try {
                throw new ArrayStoreException ();
            } catch (Exception e1) {
                int i = 1/0;
                System.out.println("==>抛出异常2" + e1.getMessage());
            }
            finally {
                int i = 1/0;
                System.out.println("==>抛出异常3");
            }
            System.out.println("==>抛出异常1" + e.getMessage());
        }finally {
            int i = 2/0;
            System.out.println("==>抛出异常4");
        }

    }

}
