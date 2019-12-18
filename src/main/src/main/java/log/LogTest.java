package log;

import org.apache.log4j.Logger;

public class LogTest {
    private static Logger logger = Logger.getLogger(LogTest.class);


    public static void main(String[] args) throws InterruptedException {
        logger.trace("跟踪信息");
        logger.debug("调试信息");
        logger.info("输出信息");
        logger.warn("警告信息");
        logger.error("错误信息");
    }

}
