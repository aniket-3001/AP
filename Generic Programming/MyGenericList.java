import java.util.ArrayList;

public class MyGenericList <T> {
    private ArrayList <T> myList;

    public MyGenericList() {
        myList = new ArrayList <T>();
    }

    public void add(T o) {
        myList.add(o);
    }

    public T get(int i) {
        return myList.get(i);
    }
}
