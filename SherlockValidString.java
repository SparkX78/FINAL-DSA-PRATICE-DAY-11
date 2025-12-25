import java.util.*;

public class SherlockValidString {
    public static String isValid(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int[] arr = new int[map.size()];
        int i = 0;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            arr[i++] = entry.getValue();
        }
        Arrays.sort(arr);
        int first = arr[0];
        int second = arr[1];
        int last = arr[arr.length-1];
        int second_last = arr[arr.length-2];

        if(first==last){
            return "YES";
        }
        if(first == 1 && second == last){
            return "YES";
        }
        if(first == second && second == second_last && second_last == (last-1)){
            return "YES";
        }
        return "NO";

    }
    public static void main(String[] args) {
        System.out.println(isValid("aabbcc"));   // YES
        System.out.println(isValid("aabbccc"));  // YES
        System.out.println(isValid("aabbcd"));    // NO
        System.out.println(isValid("abc"));      // YES
    }

}