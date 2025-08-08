class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        String temp = "";
        for(char s : myString.toCharArray()){
            if(s == 'A')
                temp += "B";
            else
                temp += "A";
        }
        if(temp.contains(pat))
            answer = 1;
        return answer;
    }
}