import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<String> checkouts = new PriorityQueue<>();
        Arrays.sort(book_time, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2){
                return o1[0].compareTo(o2[0]);
            }
        });
        for(int i = 0; i < book_time.length; i++){
            StringBuilder sb = new StringBuilder(book_time[i][1]);
            String temp = "";
            int add = book_time[i][1].charAt(3) - '0' + 1;
            if(add == 6){
                add = book_time[i][1].charAt(1) - '0' + 1;
                if(add == 10) {
                    add = book_time[i][1].charAt(0) - '0' + 1 ;
                    temp = String.valueOf(add) + "0:0";
                    sb.replace(0, temp.length(), temp);
                }
                else {
                    add = book_time[i][1].charAt(1) - '0' + 1 ;
                    temp = String.valueOf(add) + ":0";
                    sb.replace(1, 1+temp.length(), temp);
                }
            } else sb.setCharAt(3, (char)(add + '0'));
            book_time[i][1] = sb.toString();
        }
        int size = 0;
        for(String[] book: book_time){
            String checkin = book[0];
            String checkout = book[1];
            if(!checkouts.isEmpty()){
                if(checkin.compareTo(checkouts.peek()) >= 0) checkouts.poll();
            }
            checkouts.offer(checkout);
            size = checkouts.size();
            if(size > answer) answer = size;
        }
        return answer;
    }
}