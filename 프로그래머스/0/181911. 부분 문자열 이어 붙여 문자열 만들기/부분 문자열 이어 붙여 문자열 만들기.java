class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        int idx = 0;
        for(int[] p : parts){
            answer += my_strings[idx].substring(p[0], p[1]+1);
            idx +=1 ;
        }
        return answer;
    }
}