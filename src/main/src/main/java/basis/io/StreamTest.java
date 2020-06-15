package basis.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 字节流
 * InputStream字节输入流
 * OutputStream字节输出流
 * 用于以字节的形式读取和写入数据
 * <p></p>
 * 1字节=8位(1 byte = 8bit)(0 - 255)
 * 1字=2字节(1 word = 2 byte)
 * 1 KB = 1024 Bytebyte
 */
public class StreamTest {

    public static void main(String[] args) {
        File file = new File("d://log.txt");
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] all = new byte[(int) file.length()];
            fis.read(all);
            for (byte b : all) {
                System.out.println(b);
            }
            System.out.println(all.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
