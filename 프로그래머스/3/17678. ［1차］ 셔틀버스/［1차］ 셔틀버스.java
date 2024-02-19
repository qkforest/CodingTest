import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        PriorityQueue<Integer> q = new PriorityQueue<>();
        boolean find = false;
        String hour = "";
        String min = "";
        for(String time: timetable){
            int times = Integer.valueOf(time.substring(0, 2)) * 60;
            times += Integer.valueOf(time.substring(3, 5));
            q.offer(times);
        }
        for(int i = 0; i < n; i++){
            int shuttle = 540 + (t * i);
            for(int j = 0; j < m; j++){
                if(q.size() > 0){
                    if(q.peek() <= shuttle){
                        if(q.size() >= 1 && i == n-1 && j == m-1){
                            hour = String.valueOf((q.peek()-1)/60);
                            if(hour.length() == 1)
                               hour = "0"+hour;
                            min = String.valueOf((q.peek()-1)%60);
                            if(min.length() == 1)
                               min = "0"+min;             
                            answer = hour + ":" + min;
                            find = true;
                            break;
                        }
                        q.poll();
                    }else{
                        if(i == n-1 && j == m-1){
                            hour = String.valueOf(shuttle/60);
                            if(hour.length() == 1)
                               hour = "0"+hour;
                            min =  String.valueOf(shuttle%60);
                            if(min.length() == 1)
                               min = "0"+min;             
                            answer = hour + ":" + min;
                            find = true;
                            break;
                         }else
                            continue;
                    }
                } else{
                    hour = String.valueOf(shuttle/60);
                    if(hour.length() == 1)
                       hour = "0"+hour;
                    min =  String.valueOf(shuttle%60);
                    if(min.length() == 1)
                       min = "0"+min;             
                    answer = hour + ":" + min;
                    find = true;
                    break;
                }
            }
            if(find)
                break;
        }
        return answer;
    }
}