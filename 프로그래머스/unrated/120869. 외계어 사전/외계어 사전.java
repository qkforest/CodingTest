class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        for(String d: dic){
            int temp = 0;
            for(String s: spell){
                if(d.contains(s))
                    temp++;
            }
            if(temp == spell.length){
                answer = 1;
                break;
            }
        }
        return answer;
    }
}