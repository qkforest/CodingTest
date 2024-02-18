import java.util.*;
class Solution {
    static List< Double> e;
    static double[] temp = new double[2];
    static long answer = 0;
    public long solution(int k, int d) {
        int element = 0;
        e = new ArrayList<>();
        while(element*k <= d){
            e.add(Math.pow(element*k, 2));
            element++;
        }
        int max = e.size()-1;
        double dist = Math.pow(d, 2);
        for(int i = 0; i < e.size(); i++){
            if(e.get(i) + e.get(max) <= dist){
                answer += max+1;
            }else{
                while(e.get(i) + e.get(max) > dist){
                    max--;
                }
                answer += max+1;
            }
        }
        return answer;
    }
}