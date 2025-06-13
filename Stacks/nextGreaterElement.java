import java.util.*;

public class nextGreaterElement {
    public static void main(String[] args) { //O(n)
        // int arr[] = {6, 8, 0, 1, 3};
        int arr[] = {5, 3, 8, 1, 9};
        Stack<Integer> s = new Stack<>();
        int nxtGreater[] = new int[arr.length];
        int n = arr.length;

        // for(int i=n-1;i>=0; i--){ // next greater right
        for(int i=0; i<n; i++){        // next greater left
            //1. while loop
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){     //next smaller ---> while(!s.isEmpty() && arr[s.peek()] >= arr[i])
                s.pop();
            }

            //2. if-else
            if(s.isEmpty()){
                nxtGreater[i] = -1;
            }else{
                nxtGreater[i] = arr[s.peek()];
            }

            //3. push
            s.push(i);
        }

        for(int i=0; i<nxtGreater.length; i++){
            System.out.print(nxtGreater[i] + " ");
        }

        System.out.println();
    }
}
