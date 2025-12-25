import java.util.*;
public class Pairs {
    public static int pairs(int[] arr, int k){
        Arrays.sort(arr);
        int result = 0;
        for(int i : arr){
            int number_to_search = i-k;
            if(binarySearch(arr,number_to_search)){
                result++;
            }
        }
        return result;
    }
    private static boolean binarySearch(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            if(arr[mid] == x){
                return true;
            }
            else if(arr[mid] < x){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[] arr = {3,5,0,7,1,2};
        int k = 2;
        System.out.println(pairs(arr,k));
    }
}
