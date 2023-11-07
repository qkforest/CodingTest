class Solution {
    public int solution(int[] num_list) {
        int eSum = 0;
        int oSum = 0;
        for(int i = 0; i < num_list.length; i++){
            if((i+1) % 2 == 0)
                eSum += num_list[i];
            else 
                oSum += num_list[i];
        }        
        return (eSum >= oSum) ? eSum : oSum;
    }
}