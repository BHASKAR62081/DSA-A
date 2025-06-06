import java.util.ArrayList;
import java.util.Collections;

public class swapElement {
    public static void main(String[] args) {
        ArrayList <Integer> list = new ArrayList<>();

        list.add(1);
        list.add(3);
        list.add(9);
        list.add(4);
        list.add(6);


        System.out.println(list);
        swap(list,1,3);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);
    }
    public static void swap (ArrayList<Integer> list, int a, int b){
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
}
