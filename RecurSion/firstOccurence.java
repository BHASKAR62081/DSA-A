public class firstOccurence {

    public static int firstoccurence(int[] arr, int key, int i){
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }

        return firstoccurence(arr,key,i+1);
    }
    public static void main(String[] args) {
        int[] arr = {1,3,2,6,4,2,8,2,9};
        System.out.println(firstoccurence(arr, 9, 0));
    }
}
