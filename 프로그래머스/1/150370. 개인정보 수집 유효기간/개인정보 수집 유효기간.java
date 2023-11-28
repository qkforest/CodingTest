import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> term = new HashMap<>();
        int todayY = Integer.parseInt(today.substring(0, 4));
        int todayM = Integer.parseInt(today.substring(5, 7));
        int todayD = Integer.parseInt(today.substring(8, 10));
        for(String s : terms){
            String[] temp = s.split(" ");
            term.put(temp[0], Integer.parseInt(temp[1]));
        }
        for(int i = 0; i< privacies.length; i++){
            String[] temp = privacies[i].split(" ");
            Integer month = term.get(temp[1]);
            int year = 0;
            if(month > 12){
                year =  month / 12;
                month %= 12;
            }
            month += Integer.parseInt(temp[0].substring(5, 7));
            if(month > 12){
                year +=  month / 12;
                month %= 12;
            }
            int day = Integer.parseInt(temp[0].substring(8, 10)) - 1;
            if(day == 0){
                day = 28;
                month -= 1;
            }   
            if(Integer.parseInt(temp[0].substring(0, 4)) + year < todayY)
                answer.add(i+1);
            else if(Integer.parseInt(temp[0].substring(0, 4)) + year == todayY){
                if(month < todayM)
                    answer.add(i+1);
                else if(month == todayM){
                    if(day < todayD)
                        answer.add(i+1);
                }
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}