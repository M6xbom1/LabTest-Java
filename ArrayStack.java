package BalancingSymbols;

public class ArrayStack implements MyStack{

    private int total = 0;
    private Object s[];
    int top;

    public ArrayStack() {
        top =-1;
        total = 50;
        s = new Object[total];

    }

    @Override
    public void MyStack() {
        top = -1;
    }

    @Override
    public void clear() {
        top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == total-1;
    }

    @Override
    public Object pop() throws Exception {
        if(isEmpty()){
            throw new Exception("Stack is empty");
        }else{
            Object temp = s[top];
            top--;
            return temp;
        }
    }

    @Override
    public void push(Object e) throws Exception {
        if(isFull()){
            throw new Exception("Stack is full");
        }else{
            top++;
            s[top] = e;
        }
        
    }

    @Override
    public Object top() throws Exception {
        if (isEmpty()){
            throw new Exception("Stack is empty");
        }else{
            return s[top];
        }
        
    }
    
}
