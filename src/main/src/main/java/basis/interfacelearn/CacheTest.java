package basis.interfacelearn;

import org.junit.Test;

public class CacheTest {

    @Test
    public void test(){
        CacheUtils.test((CacheSelector<String>) () -> null);
    }
}
