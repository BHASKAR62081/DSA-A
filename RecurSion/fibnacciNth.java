

public class fibnacciNth {

    public static int fib(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int fnm1 = fib(n-1);
        int fnm2 = fib(n-2);
        int fnm = fnm1 + fnm2;
        return fnm;
    }
    public static void main(String[] args) {
        System.out.println(fib(5));
    }    
}
