import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = n % Math.sqrt(n) == 0 ? 1 : 2;
        return answer;
    }
}