
import java.util.ArrayList;

public class stackArrL {

    public static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();

        public  boolean isEmpty(){
            return list.size() == 0;
        }

        //push
        public  void push(int data){
            list.add(data);
        }

        //pop
        public  int  pop(){
            if (isEmpty()) {
                System.out.println("Stack Underflow");
                return -1; // or throw exception
            }

            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        //peek
        public  int peek(){
            if (isEmpty()) {
                System.out.println("Stack Underflow");
                return -1; // or throw exception
            }

            int top = list.get(list.size() - 1);
            return top;
        }

    }
    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
            //System.out.println(s.pop());
        }
    }    
}
