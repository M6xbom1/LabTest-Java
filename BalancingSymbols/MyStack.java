package BalancingSymbols;

interface MyStack {
    public void MyStack();

    public void push(Object e) throws Exception;

    public Object pop() throws Exception;

    public Object top() throws Exception;

    public boolean isEmpty();

    public boolean isFull();

    public void clear();
}
