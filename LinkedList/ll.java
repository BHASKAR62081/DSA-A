import java.util.LinkedList;

public class ll {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();

        //add node
        ll.addFirst(0);
        ll.addLast(1);
        ll.addLast(2);

        System.out.println(ll);
        
        //delete node
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);
    }
    
}
