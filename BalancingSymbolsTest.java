import javax.swing.JOptionPane;

public class BalancingSymbolsTest {
    public static void main(String[] args) throws Exception {

        //ArrayStack stack = new ArrayStack();
        LinkedStack stack = new LinkedStack();

        String ex = JOptionPane.showInputDialog(null, "What is your expression?");
        try{
            for (int i = 0; i < ex.length(); i++) {
                char c = ex.charAt(i);
                if(c == '(' || c == '{' || c == '['){
                    stack.push(c);
                    continue;
                }
                char check;
                switch(c){
                    case ')':
                    if(stack.isEmpty()){
                        throw new Exception("Stack is empty :Not Balancing Symbol");
                    }
                        check = (char)stack.top();
                        if(check == '('){
                            stack.pop();
                        }
                        else if(check == '{' || check == '['){
                            throw new Exception("Symbol does not match at position "+(i+1)+": Not Balancing Symbol");
                        }
                        break;

                    case '}':
                    if(stack.isEmpty()){
                        throw new Exception("Stack is empty :Not Balancing Symbol");
                    }
                        check = (char)stack.top();
                        if(check == '{'){
                            stack.pop();
                        }
                        else if(check == '(' || check == '['){
                            throw new Exception("Symbol does not match at position "+(i+1)+": Not Balancing Symbol");
                        }
                        break;

                    case ']':
                    if(stack.isEmpty()){
                        throw new Exception("Stack is empty :Not Balancing Symbol");
                    }
                        check = (char)stack.top();
                        if(check == '['){
                            stack.pop();
                        }
                        else if(check == '(' || check == '{'){
                            throw new Exception("Symbol does not match at position "+(i+1)+": Not Balancing Symbol");
                        }
                        break;
                    }
                }
            if(stack.isEmpty()){
                throw new Exception("Balancing Symbol");
            }
            else{
                throw new Exception("Illegal Expression : Not Balancing Symbol");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
}
