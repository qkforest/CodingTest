import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] arr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr, (a, b) -> (b+a).compareTo(a+b));
        for(String s : arr) {
            sb.append(s);
        }
        return sb.toString().replaceAll("^0+", "0");
    }
}