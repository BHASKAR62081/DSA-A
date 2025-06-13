import java.util.*;

public class stringReverse {

    public static String reverseString(String str){
        Stack<Character> ch = new Stack<>();

        for(int i=0; i<str.length(); i++){
            ch.push(str.charAt(i));
        }

        StringBuilder s = new StringBuilder();
        while(!ch.isEmpty()){
            char curr = ch.pop();
            s.append(curr);
        }
        return s.toString();
    } 
    public static void main(String[] args) {
        String str = "abc";
        String result = reverseString(str);
        System.out.println(result);
    }
}
