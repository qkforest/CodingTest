class Solution {
    public int solution(int order) {
        int answer = 0;
        for(char c: String.valueOf(order).toCharArray()){
            if(c - '0' == 3|| c - '0' == 6|| c - '0' == 9)
                answer += 1;
        }
        return answer;
    }
}