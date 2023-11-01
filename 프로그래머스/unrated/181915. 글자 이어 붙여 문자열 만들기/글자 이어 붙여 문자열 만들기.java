class Solution {
    public String solution(String my_string, int[] index_list) {
        String answer = "";
        char[] S = my_string.toCharArray();
        for(int i : index_list){
            answer += String.valueOf(S[i]);
        }
        return answer;
    }
}