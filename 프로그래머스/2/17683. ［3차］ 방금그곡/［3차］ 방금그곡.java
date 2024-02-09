import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int ansLen = 0;
        String[] origin = {"C#", "D#", "F#", "G#", "A#"};
        String[] chage = {"H", "I", "J", "K", "L"};
        for(String infos : musicinfos){
            String[] info = infos.split(",");
            int endtime = Integer.parseInt(info[1].substring(3));
            int starttime = Integer.parseInt(info[0].substring(3));
            int playtime =  endtime - starttime;
            endtime = Integer.parseInt(info[1].substring(0, 2));
            starttime = Integer.parseInt(info[0].substring(0, 2));
            if(playtime < 0) {
                playtime += 60;
                playtime = (endtime-1-starttime) * 60 + playtime;
            } else playtime = (endtime-starttime) * 60 + playtime;
            for(int i = 0; i < origin.length; i++){
                info[3] = info[3].replaceAll(origin[i], chage[i]);
                m = m.replaceAll(origin[i], chage[i]);
            }
            int len = info[3].length();
            String play = info[3].repeat(playtime/len) + info[3].substring(0, playtime%len);
            if(play.contains(m) && playtime > ansLen){
                answer = info[2];
                ansLen = playtime;
            }  
        }
        return answer;
    }
}