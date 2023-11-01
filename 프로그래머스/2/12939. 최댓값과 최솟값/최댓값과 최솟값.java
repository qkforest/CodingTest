import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int[] temp = Arrays.stream(s.split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        int max = Arrays.stream(temp).max().getAsInt();
		int min = Arrays.stream(temp).min().getAsInt();
        answer = String.valueOf(min) + " " + String.valueOf(max);
        return answer;
    }
}