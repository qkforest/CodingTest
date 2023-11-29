class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health, idx = 0, con = 0;
        for(int i = 1; i <= attacks[attacks.length-1][0]; i++){
            if(attacks[idx][0] == i){
                answer -= attacks[idx][1];
                if(answer <= 0){
                    answer = -1;
                    break;
                }
                con = 0;
                idx += 1;
            }
            else {
                con += 1;
                answer = answer + bandage[1] > health ? health : answer + bandage[1];
                if(con == bandage[0]){
                    answer = answer + bandage[2] > health ? health : answer + bandage[2];
                    con = 0;
                }
            }
        }
        return answer;
    }
}