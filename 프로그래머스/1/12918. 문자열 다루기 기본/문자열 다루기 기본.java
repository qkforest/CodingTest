class Solution {
    public boolean isNumber(String s){
        try{
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() == 4 || s.length() == 6){
            for(char c: s.toCharArray()){
                if(!isNumber(String.valueOf(c))){
                    answer = false;
                    break;
                }
            }
        } else
            answer = false;
        return answer;
    }
}