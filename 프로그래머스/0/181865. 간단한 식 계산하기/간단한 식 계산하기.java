class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String[] temp = binomial.split(" ");
        switch(temp[1]){
            case "+":
                answer = Integer.valueOf(temp[0]) + Integer.valueOf(temp[2]);
                break;
            case "-":
                answer = Integer.valueOf(temp[0]) - Integer.valueOf(temp[2]);
                break;
            case "*":
                answer = Integer.valueOf(temp[0]) * Integer.valueOf(temp[2]);
                break;
        }
        return answer;
    }
}