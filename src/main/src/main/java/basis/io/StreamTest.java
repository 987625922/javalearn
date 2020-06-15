package basis.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

    @Test
    public void test() throws IOException {
        outPutStreamTest();
        inputStreamTest();
    }

    //已字节流读取文件
    private void inputStreamTest() throws IOException {
        File file = new File("d://log.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] all = new byte[(int) file.length()];
        fis.read(all);
        for (byte b : all) {
            System.out.println(b);
        }
        fis.close();
    }

    private void outPutStreamTest() throws IOException {
        File file = new File("d://log.txt");
        byte data[] = {88, 89};
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(data);
        fos.close();
    }

}
