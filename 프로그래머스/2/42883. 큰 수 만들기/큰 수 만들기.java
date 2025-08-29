import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : number.toCharArray()) {
            while(k > 0 && !stack.isEmpty() && c > stack.peekLast()) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(c);
        }
        while(k-- > 0) {
            stack.pollLast();
        }
        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }
}