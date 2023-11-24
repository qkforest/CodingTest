class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int c1 = 0, c2 = 0;
        for(String word : goal){
            if(cards1[c1].equals(word)){
                if(c1 < cards1.length-1)
                    c1++;
            } else if(cards2[c2].equals(word)){
                if(c2 < cards2.length-1)
                    c2++;
            } else {
                answer = "No";
                break;
            }
        }
        return answer;
    }
}