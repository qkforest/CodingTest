import java.util.stream.IntStream;

class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        if(arr1.length == arr2.length){
            if(IntStream.of(arr1).sum() - IntStream.of(arr2).sum() > 0)
                answer = 1;
            else if(IntStream.of(arr1).sum() - IntStream.of(arr2).sum() < 0)
                answer = -1;
        } else {
            if(arr1.length - arr2.length > 0)
                answer = 1;
            else if(arr1.length - arr2.length < 0)
                answer = -1;
        }
        return answer;
    }
}