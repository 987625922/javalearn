package basis.io;

import java.io.*;

/**
 * 在只针对将字符写入文件的时候，因为 每次使用 转换流，对字节流进行包装，
 * 写法太麻烦，所以jdk 提供了 字节转换流子类FileReader & FileWriter，方便的进行字符文件的IO操作
 */
public class FileReaderOrFileWriter {

    // 使用 字符转换流， 实现文本文件的 拷贝
    // 一次拷贝一个 字符
    private static void copyFile1(String src, String dest) throws IOException {
        //1. 创建转换流
        Reader reader = new FileReader(src);
        Writer writer = new FileWriter(dest);

        //2. 拷贝数据
        int data = reader.read();
        while (data != -1) {
            writer.write(data);
            data = reader.read();
        }
        //3.关闭流
        reader.close();
        writer.close();
    }

    // 一次拷贝一个 字符数组
    private static void copyFile2(String src, String dest) throws IOException {
        //1. 创建转换流
        Reader reader = new FileReader(src);
        Writer writer = new FileWriter(dest);

        //2. 拷贝数据
        char[] buffer = new char[2048];
        int len = reader.read(buffer);
        while (len != -1) {
            writer.write(buffer, 0, len);
            len = reader.read(buffer);
        }
        //3.关闭流
        reader.close();
        writer.close();
    }

}
