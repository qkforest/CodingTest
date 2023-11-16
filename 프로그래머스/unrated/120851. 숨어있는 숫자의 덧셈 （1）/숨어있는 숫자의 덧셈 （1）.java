class Solution {
    public boolean isInteger(String c){
        if(c == null)
            return false;
        try{
            int n = Integer.parseInt(c);
        }catch(NumberFormatException e){
            return false;
        }
        return true;
    }
    public int solution(String my_string) {
        int answer = 0;
        for(char c: my_string.toCharArray()){
            if(isInteger(String.valueOf(c)))
                answer += Integer.parseInt(String.valueOf(c));
        }
        return answer;
    }
}