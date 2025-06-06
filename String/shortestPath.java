import java.util.*;

public class shortestPath {
    public static float findshortestPath(String str){
        int x = 0, y = 0;
        for(int i=0; i<str.length(); i++){
            //char ch = str.charAt(i);
            if(str.charAt(i) == 'w'){
                x--;
            }else if (str.charAt(i) == 'e'){
                x++;
            }else if(str.charAt(i) == 'n'){
                y++;
            }else if(str.charAt(i) == 's'){
                y--;
            }
        }
        int x2 = x*x;
        int y2 = y*y;
        return (float)Math.sqrt(x2+y2);
    }
    public static void main(String[] args) {
        String str;
        try (// @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the String :");
            str = sc.next();
        }
        System.out.println(findshortestPath(str));
    }
}
