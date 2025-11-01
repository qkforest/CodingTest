class Solution {
    public boolean isInteger(String s){
        try{
            Integer.valueOf(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
    public int solution(String my_string) {
        int answer = 0;
        String temp = "";
        for(char c : my_string.toCharArray()){
            if(isInteger(String.valueOf(c)))
                temp += c;
            else {
                if(temp.equals(""))
                    answer += 0;
                else {
                    answer += Integer.parseInt(temp);
                    temp = "";
                }
            }
        }
        if(!temp.equals(""))
            answer += Integer.parseInt(temp);
        return answer;
    }
}