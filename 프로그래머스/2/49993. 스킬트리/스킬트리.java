class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0, pre = 0, curr = 0;
        for(String s : skill_trees){
            boolean ans = true;
            pre = s.indexOf(skill.charAt(0));
            for(int i = 1; i < skill.length(); i++){
                curr = s.indexOf(skill.charAt(i));
                if(pre >= 0 && pre < curr) pre = curr;
                else if(pre == -1 && curr == -1) continue;
                else if(pre >= 0 && curr == -1) {
                    pre = curr;
                    continue;
                } 
                else {
                    ans = false;
                    break;
                }
            }
            if(ans) answer++;
        }
        return answer;
    }
}