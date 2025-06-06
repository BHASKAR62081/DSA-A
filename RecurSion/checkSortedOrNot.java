public class checkSortedOrNot {

    public static boolean isSorted(int [] arr, int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        // if(arr[i] <= arr[i+1]){
        //     return true;
        // } 
        return isSorted(arr,i+1);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,6,4,5};
        System.out.println(isSorted(arr,0));
    }
}
