class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char curr;
        for(char c: s.toCharArray()){
            curr = c;
            for(int i = 1; i <= index; i++){
                curr += (curr == 'z') ? -25 : 1;
                while(skip.contains(String.valueOf(curr))){
                    curr += 1;
                    if(curr > 'z')
                        curr -= 26;
                }
            }
            answer += curr;
        }
        return answer;
    }
}