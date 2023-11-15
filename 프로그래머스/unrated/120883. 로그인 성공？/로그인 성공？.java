class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        for(String[] info : db){
            if(id_pw[0].equals(info[0]) && id_pw[1].equals(info[1])){
                answer = "login";
                break;
            }
            if(id_pw[0].equals(info[0]))
                answer = "i";
        }
        if(answer.equals("") )
            answer = "fail";
        if(answer.equals("i"))
            answer = "wrong pw";

        return answer;
    }
}