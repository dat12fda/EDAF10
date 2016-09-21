package datastructures;

public class Stack implements SuperStack, SuperStack2 {

    private java.util.LinkedList<Object> list = new java.util.LinkedList<Object>();
    
    /* (non-Javadoc)
	 * @see datastructures.SuperStack2#push(java.lang.Object, int)
	 */
    @Override
	public void push(Object o, int i) {
        getList().add(o);
    }
    
    /* (non-Javadoc)
	 * @see datastructures.SuperStack2#pop()
	 */
    @Override
	public Object pop() {
        return getList().removeLast();
    }

	java.util.LinkedList<Object> getList() {
		return list;
	}

	@Override
	public void setList(java.util.LinkedList<Object> list) {
		this.list = list;
	}
    
    
}
