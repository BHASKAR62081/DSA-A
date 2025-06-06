// import java.util.*;

// public class reverseString {
//     public static String revString(String str){
//         String revStr = "";
//         int n = str.length();
//         for(int i=n-1; i>=0; i--){
//             revStr += str.charAt(i);
//         }
//             return revStr;
        
//     }
//     public static void main(String[] args) {
//         String str;
//         try (Scanner sc = new Scanner(System.in)) {
//             System.out.println("Enter the String: ");
//             str = sc.next();
//         }
//         System.out.println("Revrsed String is: " + revString(str));


//     }
// }


import java.util.*;

public class reverseString {
    public static String revString(String str) {
        StringBuilder revStr = new StringBuilder(str);
        return revStr.reverse().toString();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the String: ");
            String str = sc.nextLine();
            System.out.println("Reversed String is: " + revString(str));
        }
    }
}
