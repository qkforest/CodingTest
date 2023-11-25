import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int count;
        int[] counts = new int[number];
        for(int i = 0; i < number; i++){
            count = 0;
            for(int j = 1; j <= Math.sqrt(i+1); j++){
                if(j == Math.sqrt(i+1))
                    count++;
                else if((i+1) % j == 0)
                    count += 2;
                if(count > limit){
                    counts[i] = power;
                    break;
                }
            }
            if(count <= limit)
                counts[i] = count;
        }
        return Arrays.stream(counts).sum();
    }
}