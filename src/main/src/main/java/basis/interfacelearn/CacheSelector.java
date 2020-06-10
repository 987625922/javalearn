package basis.interfacelearn;

@FunctionalInterface
public interface CacheSelector<T> {
    T select();
}
