package basis.io;

import java.io.*;

public class InputStreamReaderOrOutputStreamReader {
    public static void main(String[] args) {

    }

    // 使用 字符转换流， 实现文本文件的 拷贝
    // 一次拷贝一个 字符
    private static void copyFile1(String src, String dest) throws IOException {
        //1. 创建转换流
        Reader reader = new InputStreamReader(new FileInputStream(src));
        Writer writer = new OutputStreamWriter(new FileOutputStream(dest));

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
        Reader reader = new InputStreamReader(new FileInputStream(src));
        Writer writer = new OutputStreamWriter(new FileOutputStream(dest));

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
