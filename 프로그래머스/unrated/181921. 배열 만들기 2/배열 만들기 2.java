import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = l; i <= r ; i++){
            for(int j = 0; j < String.valueOf(i).length(); j++){
                if(!(String.valueOf(i).toCharArray()[j] == '5' || String.valueOf(i).toCharArray()[j] == '0'))
                    break;
                if(j == String.valueOf(i).length() - 1)
                    answer.add(i);
            
                }
        }

        if (answer.size() == 0)
            answer.add(-1);
        return answer.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}