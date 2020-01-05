package basis.io;


import java.io.*;

/**
 * FileInputStream & FileOutputStream 可以从文件系统中 读取/写入 诸如图像数据之类的原始字节流。
 */
public class FileInputStreamOrFileOutputStream {

    public static void main(String[] args) {


    }

    // 使用文件字节流 一次拷贝一个字节
    private static void copyFile1(String src, String dest) throws IOException {
        //1. 创建流
        InputStream in = new FileInputStream(src);
        OutputStream os = new FileOutputStream(dest);

        //2. 读写数据
        int data = in.read();
        while (data != -1) {
            os.write(data);
            data = in.read();
        }

        //3. 关闭流
        in.close();
        os.close();
    }

    // 使用文件字节流 一次拷贝一个字节数组
    private static void copyFile2(String src, String dest) throws IOException {
        //1. 创建流
        InputStream in = new FileInputStream(src);
        OutputStream os = new FileOutputStream(dest);

        //2. 读写数据
        byte[] buffer = new byte[2048];
        int len = in.read(buffer);
        while (len != -1) {
            os.write(buffer, 0, len);
            len = in.read(buffer);
        }
        //3. 关闭流
        in.close();
        os.close();
    }

}
