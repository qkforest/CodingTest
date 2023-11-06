class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int a_idx = 0;
        int h_idx = 0;
        for(int i = 0; i <= attacks[attacks.length-1][0]; i++){
            if(answer <= 0) break;
            if(i == attacks[a_idx][0]){
                answer -= attacks[a_idx][1];
                h_idx = 0;
                a_idx += 1;
            } else {
                if(answer < health){
                    if(h_idx == bandage[0]-1){
                        answer = (bandage[2] + answer + bandage[1] >= health) ? health : bandage[2] + answer + bandage[1];
                        h_idx  = 0;
                    }else{
                        answer = (bandage[1] + answer >= health) ? health : bandage[1] + answer;
                        h_idx += 1;
                    }
                }
            }
            System.out.println(String.valueOf(i) + " " + String.valueOf(h_idx) + " " + String.valueOf(answer));
        }
        return (answer <= 0) ? -1 : answer;
    }
}