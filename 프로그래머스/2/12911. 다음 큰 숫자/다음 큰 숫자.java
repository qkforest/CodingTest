class Solution {
    public int solution(int n) {
        int answer = 0, count = 0, temp;
        boolean search = true;
        for(char c : Integer.toBinaryString(n).toCharArray()){
            if(c == '1')
                count++;
        }
        while(search){
            n += 1;
            temp = 0;
            for(char c : Integer.toBinaryString(n).toCharArray()){
                if(temp > count)
                    break;
                if(c == '1')
                    temp++;
            }
            if(count == temp){
                answer = n;
                search = false;
            }
        }
        return answer;
    }
}