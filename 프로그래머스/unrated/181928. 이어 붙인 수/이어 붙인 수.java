class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        String odd = "";
        String even = "";
        for (int c : num_list){
            if(c % 2 == 0)
                even += String.valueOf(c);
            else
                odd += String.valueOf(c);
        }
        answer = Integer.valueOf(odd) + Integer.valueOf(even); 
        return answer;
    }
}