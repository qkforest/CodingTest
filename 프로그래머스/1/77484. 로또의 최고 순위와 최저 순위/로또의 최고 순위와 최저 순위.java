import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int same = 0, zero = 0;
        int[] answer = new int[2];
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        if(Arrays.equals(lottos, new int[]{0, 0, 0, 0, 0, 0}))
            return new int[] {1, 6};
        else if(Arrays.equals(lottos, win_nums))
            return new int[] {1, 1};
        else{
            for(int i = 0; i < lottos.length; i++){
                if(lottos[i] == 0)
                    zero++;
                else{
                    for(int n : win_nums){
                        if(lottos[i] == n)
                            same++;
                    }
                } 
            }
            answer[0] = 7 - (same+zero) >= 6 ? 6 : 7 - (same+zero);
            answer[1] = 7 - same >= 6 ? 6 : 7 - same;
        }
        return answer;
    }
}