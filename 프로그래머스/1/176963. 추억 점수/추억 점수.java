import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        for(int i = 0; i < photo.length; i++){
            for(String n : photo[i]){
                if(Arrays.asList(name).indexOf(n) != -1)
                    answer[i] += yearning[Arrays.asList(name).indexOf(n)];
            }
        }
        return answer;
    }
}