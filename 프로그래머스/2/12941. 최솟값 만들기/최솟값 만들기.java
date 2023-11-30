import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A); Arrays.sort(B);
        int answer = 0, aMin = 0, aMax = A.length-1, bMin = 0, bMax = B.length-1;
        for(int i = 0; i < A.length; i++){
            if(A[aMin] * B[bMax] < A[aMax] * B[bMin]){
                answer += A[aMin] * B[bMax];
                aMin++;
                bMax--;
            } else {
                answer += A[aMax] * B[bMin];
                bMin++;
                aMax--;
            }
        }
        return answer;
    }
}