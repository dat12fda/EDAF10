package unknown;

public class Unknown {

    java.util.LinkedList<Object> list = new java.util.LinkedList<Object>();
    
    public void put(Object o) {
        list.add(o);
    }
    
    public Object get() {
        return list.removeLast();
    }

}
