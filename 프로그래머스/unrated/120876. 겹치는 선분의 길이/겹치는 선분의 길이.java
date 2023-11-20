import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        Arrays.sort(lines, (o1, o2) -> { 
            return o1[0] - o2[0];
        });
        if(!(lines[0][0] >= lines[1][1]) && !(lines[0][1] <= lines[1][0])){
            if(lines[0][1] < lines[1][1])
                answer += lines[0][1] - lines[1][0];
            else
                answer += lines[1][1] - lines[1][0];
        }
        System.out.println(answer);
        if(!(lines[1][0] >= lines[2][1]) && !(lines[1][1] <= lines[2][0])){
            if(lines[1][1] < lines[2][1])
                answer += lines[1][1] - lines[2][0];
            else
                answer += lines[2][1] - lines[2][0];
        }
        System.out.println(answer);
        if(!(lines[0][0] >= lines[2][1]) && !(lines[0][1] <= lines[2][0])){
            if(lines[0][1] < lines[2][1])
                answer += lines[0][1] - lines[2][0];
            else
                answer += lines[2][1] - lines[2][0];
        }
        System.out.println(answer);
        int x1 = lines[2][0], x2 = lines[0][1];
        if(lines[1][1] < x2 && lines[1][1] < lines[2][1])
            x2 = lines[1][1];
        if(lines[2][1] < x2 && lines[2][1] < lines[1][1])
            x2 = lines[2][1];
        if(!(lines[0][1] < x1 || lines[0][0] > x2 || lines[1][1] < x1 || lines[1][0] > x2 || lines[2][1] < x1 || lines[2][0] > x2))
            answer -= (x2-x1)*2;
        return answer;
    }
}