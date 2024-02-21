import java.util.TreeMap;
class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int leftMin = a[0];
        TreeMap<Integer, Integer> rightMin = new TreeMap<>();
        for(int i = 0; i < a.length; i++)
            rightMin.put(a[i], i);
        for(int i = 0; i < a.length; i ++){
            rightMin.remove(a[i]);
            if(i == 0 || i == a.length-1)
                answer++;
            else{
                if(a[i] < leftMin)
                    answer++;
                else{
                    if(a[i] < rightMin.firstKey())
                        answer++;
                }
            }
            if(a[i] < leftMin)
                leftMin = a[i];
        }
        return answer;
    }
}