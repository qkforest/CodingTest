import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        ArrayList<Integer> answer = new ArrayList<>();
        int idx = 0;
        switch(n){
            case 1:
                for(int num : Arrays.copyOfRange(num_list, 0, slicer[1]+1))
                    answer.add(num);
                break;
            case 2:
                for(int num : Arrays.copyOfRange(num_list, slicer[0], num_list.length))
                    answer.add(num);
                break;
            case 3:
                for(int num : Arrays.copyOfRange(num_list, slicer[0], slicer[1]+1))
                    answer.add(num);
                break;
            case 4:
                idx = slicer[2];
                for(int num : Arrays.copyOfRange(num_list, slicer[0], slicer[1]+1)){
                    if(idx == slicer[2]){
                         answer.add(num);
                        idx = 0;
                    }
                    idx+=1;
                }
                break;
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}