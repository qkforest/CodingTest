import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        List<Integer> list = new ArrayList<>();
        
        for(String o : operations) {
            String[] arr = o.split(" ");
            if(arr[0].equals("I")) { 
                list.add(Integer.parseInt(arr[1]));
            } else {
                if(list.isEmpty()){
                    continue;
                }
                Collections.sort(list);
                if(arr[1].equals("-1")) {
                    list.remove(0);
                } else {
                    list.remove(list.size()-1);
                }
            }
        }
        
        if(!list.isEmpty()){
            Collections.sort(list);
            answer[0] = list.get(list.size()-1);
            answer[1] = list.get(0); 
        }
        
        return answer;
    }
}