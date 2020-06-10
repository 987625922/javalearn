package basis.interfacelearn;

public class CacheUtils {

    public static <T> T test(CacheSelector<T> cacheSelector) {
        T t = cacheSelector.select();
        return t;
    }

}
