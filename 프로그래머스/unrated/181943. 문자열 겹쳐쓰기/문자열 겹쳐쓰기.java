class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        int k = 0;
        char[] temp = my_string.toCharArray();
        for(int i = s; i < s+overwrite_string.length() ; i++){
            temp[i] = overwrite_string.toCharArray()[k];
            k+=1;
        }
        answer = String.valueOf(temp);
        return answer;
    }
}