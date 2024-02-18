class Solution
{
    public int solution(String s)
    {
        int answer = 1, idx = 1, l = 0, r= 0, temp = 0;
        while(idx < s.length()){
            if(s.charAt(idx) == s.charAt(idx-1)){
                l = idx - 2;
                r = idx + 1;
                temp = 2;
                while(l >= 0 && r < s.length()){
                    if(s.charAt(l) == s.charAt(r)){
                        l--;
                        r++;
                        temp+=2;
                    } else
                        break;
                }
                answer = Math.max(answer, temp);
            }
            temp = 1;
            l = idx - 1;
            r = idx + 1;
            while(l >= 0 && r < s.length()){
                if(s.charAt(l) == s.charAt(r)){
                    l--;
                    r++;
                    temp+=2;
                }else
                    break;
            }
            answer = Math.max(answer, temp);
            idx++;
        }
        return answer;
    }
}