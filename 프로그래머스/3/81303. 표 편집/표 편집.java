import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> remove = new Stack<>();
        int tableSize = n;
        for(String c : cmd){
            switch(c.charAt(0)){
                case 'U':
                    k -= Integer.parseInt(c.substring(2));
                    break;
                case 'D':
                    k += Integer.parseInt(c.substring(2));
                    break;
                case 'C':
                    remove.push(k);
                    tableSize--;
                    if(k == tableSize)
                        k--;
                    break;
                case 'Z':
                    if(remove.pop() <= k)
                        k++;
                    tableSize++;
                    break;
            }
        }
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < tableSize; i++)
            answer.append("O");
        while(!remove.isEmpty())
            answer.insert(remove.pop(), "X");
        return answer.toString();
    }
}