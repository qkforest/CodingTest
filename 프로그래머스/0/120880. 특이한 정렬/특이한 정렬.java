import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        List<Integer> answer = new ArrayList<>();
        int minD = 100000, idx = 0;
        int l = 1, r = 1;
        Arrays.sort(numlist);
        for(int i = 0; i < numlist.length; i++){
            if(Math.abs(numlist[i] - n) < minD){
                minD = Math.abs(numlist[i] - n);
                idx = i;
            }
        }
        answer.add(numlist[idx]);
        while(idx-l >= 0 && idx+r < numlist.length){
            if(Math.abs(numlist[idx-l] - n) < Math.abs(numlist[idx+r] - n)){
                answer.add(numlist[idx-l]);
                l+=1;
            } else if(Math.abs(numlist[idx-l] - n) > Math.abs(numlist[idx+r] - n)){
                answer.add(numlist[idx+r]);
                r+=1;
            } else {
                if(numlist[idx+r] > numlist[idx-l]){
                    answer.add(numlist[idx+r]);
                    answer.add(numlist[idx-l]);
                    r+=1;
                    l+=1;
                } else {
                    answer.add(numlist[idx-l]);
                    answer.add(numlist[idx+r]);
                    r+=1;
                    l+=1;
                }
            }
        }
        if(!answer.contains(numlist[0])) {
            for(int i = idx-l; i >= 0; i--)
                answer.add(numlist[i]);
        } 
        if(!answer.contains(numlist[numlist.length-1])) {
            for(int i = idx+r; i < numlist.length; i++)
                answer.add(numlist[i]);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}