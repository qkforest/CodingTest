import java.util.*;
class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        if(adv_time.equals(play_time))
            return "00:00:00";
        int[] times = new int[360000];
        int play = toIntTime(play_time);
        int ad = toIntTime(adv_time);
        for(String log : logs){
            String[] t = log.split("-");
            int start = toIntTime(t[0]);
            int end = toIntTime(t[1]);
            for(int i = start; i < end; i++)
                times[i]++;
        }
        int idx = 0;
        long sum = 0;
        for(int i = 0; i < ad; i++){
            sum += times[i];
        }
        long maxSum = sum;
        for(int i = ad; i < play; i++){
            sum += times[i] - times[i-ad];
            if(sum > maxSum) {
                maxSum = sum;
                idx = i - ad + 1;
            }
        }
        
        return toStringTime(idx);
    }
    public int toIntTime(String s){
        int[] temp = Arrays.stream(s.split(":"))
            .mapToInt(Integer::parseInt)
            .toArray();
        return 3600 * temp[0] + 60 * temp[1] + temp[2];
    }
    public String toStringTime(int t){
        int H = t / 3600;
        int M = (t - 3600 * H) / 60;
        int S = t - 3600 * H - 60 * M;
        return (H < 10 ? "0" : "") + H + ":" +
            (M < 10 ? "0" : "") + M + ":" +
            (S < 10 ? "0" : "") + S;
    }
}