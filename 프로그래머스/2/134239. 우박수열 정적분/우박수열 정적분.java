import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> points = new ArrayList<>();
        List<Double> area = new ArrayList<>();
        int x = 0, y = k;
        
        area.add((double) 0);
        while(true){
            points.add(y);
            if(y == 1)
                break;
            if(y % 2 == 0) 
                y /= 2;
            else
                y =  3 * y + 1;
            x++;
            area.add((points.get(x-1) + y)/(double)2);
        }

        for(int i = 0; i < ranges.length; i++){
            double sum = 0;
            int end = points.size()-1 + ranges[i][1];
            if(ranges[i][0] < end){
                for(int j = ranges[i][0]+1; j <= end; j++)
                    sum += area.get(j);
                answer[i] = sum;
            }
            else if(ranges[i][0] == end)
                answer[i] = 0;
            else
                answer[i] = -1;
        }
        
        return answer;
    }
}