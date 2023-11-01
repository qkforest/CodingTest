import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        HashMap<Integer, Integer> num = new HashMap<>();
        int[] arr = {a, b, c, d};
        for(int i: arr){
            if(num.containsKey(i))
                num.put(i, num.get(i)+1);
            else
                num.put(i, 1);
        }
        switch(num.size())
        {
            case 1:
                answer = 1111 * (Integer)num.keySet().toArray()[0];
                break;
            case 2:
                int [] temp = num.keySet().stream().mapToInt(Integer::intValue).toArray();
                if(num.get(temp[0]) == 2)
                    answer = (temp[0] + temp[1]) * (Math.abs(temp[0] - temp[1]));
                else {
                    if(num.get(temp[0]) == 1)
                         answer = (int) Math.pow((int) (10 * temp[1] + temp[0]), 2);
                    else 
                        answer = (int) Math.pow((int) (10 * temp[0] + temp[1]), 2);
                }
                break;
            case 3:
                int m = 1;
                for (int i: num.keySet().stream().mapToInt(Integer::intValue).toArray()){
                    if(num.get(i) == 2)
                        continue;
                    else {
                        m = m * i;
                    }
                }
                answer = m;
                break;
            case 4:
                answer = (Integer)Collections.min(num.keySet());
        }  
        return answer;
    }
}