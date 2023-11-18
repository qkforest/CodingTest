class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuffer sb = new StringBuffer(my_string);
        char temp = my_string.charAt(num2);
        sb.setCharAt(num2, my_string.charAt(num1));
        sb.setCharAt(num1, temp);
        String answer = sb.toString();
        return answer;
    }
}