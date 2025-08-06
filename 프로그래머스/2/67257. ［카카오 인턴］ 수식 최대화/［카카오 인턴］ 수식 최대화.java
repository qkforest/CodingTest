import java.util.*;

class Solution {
    private long answer;
    private final String[] operators = {"+", "-", "*"};
    private Set<String> set; 
    
    private String compute(String op, String a, String b) {
        Long n1 = Long.parseLong(a);
        Long n2 = Long.parseLong(b);
        switch(op) {
                case "+" :
                    return String.valueOf(n1+n2);
                case "-" :
                    return String.valueOf(n1-n2);
                case "*" :
                    return String.valueOf(n1*n2);
        }
        return "0";
    }

    private void dfs(Deque<String> deque) {
        if(set.size() == 0){
            answer = Math.max(answer, Math.abs(Long.parseLong(deque.pop())));
            return;
        }
        for(int i = 0; i < 3; i++) {
            if(set.contains(operators[i])) {
                set.remove(operators[i]);
                Deque<String> temp = new ArrayDeque<>(deque);
                int count = temp.size();

                while(count-- > 0) {
                    String s = temp.pollFirst();
                    if(s.equals(operators[i])) {
                        temp.offerLast(compute(operators[i], temp.pollLast(), temp.pollFirst()));
                        count--;
                    } else {
                        temp.offerLast(s);
                    }
                }
                dfs(temp);
                set.add(operators[i]);
            }
        }
    }

    public long solution(String expression) {
        answer = 0;
        Deque<String> deque = new ArrayDeque<>();
        set = new HashSet<>();
        StringBuilder num = new StringBuilder();
        
        for(char c : expression.toCharArray()) {
            if(c >= '0' && c <= '9') {
                num.append(c);   
            } else {
                deque.offerLast(num.toString());
                deque.offerLast(String.valueOf(c));
                set.add(String.valueOf(c));
                num.setLength(0);
            }
        }
        deque.offerLast(num.toString());
        
        dfs(deque);
        return answer;
    }
}
