import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> pIndex = new Stack<>();
        Stack<Integer> dIndex = new Stack<>();
        int pCount = 0;
        int dCount = 0;
        int p = 0;
        int d = 0;
        for(int i = 0; i < n; i++){
            if(pickups[i] != 0)
                pIndex.push(i);
            if(deliveries[i] != 0)
                dIndex.push(i);
            pCount += pickups[i];
            dCount += deliveries[i];
        }
        
        while(pCount > 0 || dCount > 0){
            if(!pIndex.isEmpty())
                p = pIndex.peek();
            else
                p = 0;
            if(!dIndex.isEmpty())
                d = dIndex.peek();
            else
                d = 0;
            answer += 2 * (Math.max(p, d) + 1);
            if(dCount > 0){
                int count = cap;
                if(deliveries[d] > count)
                    deliveries[d] -= count;
                else{
                    while(deliveries[d] <= count && !dIndex.isEmpty()){
                        count -= deliveries[d];
                        dIndex.pop();
                        if(!dIndex.isEmpty())
                            d = dIndex.peek();
                    }
                    if(!dIndex.isEmpty()){
                        deliveries[d] -= count;
                    }
                }
                dCount -= cap;
            }
            if(pCount > 0){
                int count = cap;
                if(pickups[p] > count)
                    pickups[p] -= count;
                else{
                    while(pickups[p] <= count && !pIndex.isEmpty()){
                        count -= pickups[p];
                        pIndex.pop();
                        if(!pIndex.isEmpty())
                            p = pIndex.peek();
                    }
                    if(!pIndex.isEmpty()){
                        pickups[p] -= count;
                    }
                    
                }
                pCount -= cap;
            }
        }
        return answer;
    }
}