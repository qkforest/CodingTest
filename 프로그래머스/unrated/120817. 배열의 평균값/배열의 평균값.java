import java.util.*;
class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        answer = Arrays.stream(numbers).average().orElse(Double.NaN);
        return answer;
    }
}