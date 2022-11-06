package BalancingSymbols;

public class LinkedStack implements MyStack{

    Object e;
    MyNode top;

    public LinkedStack() {
        MyStack();
    }
    
    @Override
    public void MyStack() {
        top = null;
    }

    @Override
    public void clear() {
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Object pop() throws Exception {
        if(isEmpty()){
            throw new Exception("Stack is empty");
        }else{
            Object temp = top.getData();
            top = top.getNextNode();
            return temp;
        }

        }

    @Override
    public void push(Object e) throws Exception {
            top = new MyNode(e,top);
    }

    @Override
    public Object top() throws Exception {
        if (isEmpty()){
            throw new Exception("Stack is empty");
        }
        return top.getData();
    }
    
}
