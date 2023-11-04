class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        System.out.print('A'-'a');
        for(char s: my_string.toCharArray()){
            if(s - 'a' < 0)
                answer[(s - 'a')+32] += 1;
            else
                answer[(s - 'a')+26] += 1;
        }
        
        return answer;
    }
}