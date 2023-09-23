public class Pair <T1, T2> {
    private T1 key;
    private T2 value;

    public Pair(T1 _k, T2 _v) {
        key = _k; value = _v;
    }
    
    public T1 getKey() { return key; }
    public T2 getValue() { return value; }
}