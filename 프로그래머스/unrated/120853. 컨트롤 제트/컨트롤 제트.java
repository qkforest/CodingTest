class Solution {
    public int solution(String s) {
        int answer = 0;
        int former = 0;
        for(String str : s.split(" ")){
            if(str.equals("Z")){
                answer -= former;
            } else {
                answer += Integer.parseInt(str);
                former = Integer.parseInt(str);
            }
        }
        return answer;
    }
}