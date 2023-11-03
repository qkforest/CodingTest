import java.util.*;

class Solution {
public static int[] solution(int N, int[] stages) {
        HashMap<Integer, Double> map = new HashMap<>();
        
        int[] FailCnts = new int[N+2];
        int[] TotalCnts = new int[N+1];	
  
        for(int stage : stages) {
        	FailCnts[stage]++;
        }
        TotalCnts[N] = FailCnts[N]+FailCnts[N+1]; 
    
        for(int i = N-1; i >=1 ; i--) {
        	TotalCnts[i] = FailCnts[i] + TotalCnts[i+1];
        }
        
        for(int i = 1; i < TotalCnts.length; i++) {
        	if(FailCnts[i] == 0 || TotalCnts[i] == 0) {
        		map.put(i, 0.0);
        	}else {
            	map.put(i, (double)FailCnts[i] / TotalCnts[i]);
        	}
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> Double.compare(map.get(o2), map.get(o1)));
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}