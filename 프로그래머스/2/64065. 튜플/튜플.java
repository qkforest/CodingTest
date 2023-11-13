import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String s) {
        s = s.replaceAll("\\{", "");
        String[] sArr = s.substring(0, s.length() - 2).split("\\}\\,");
        Arrays.sort(sArr, Comparator.comparingInt(String::length));
 
        HashSet<Integer> dup = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
 
        for (int i = 0; i < sArr.length; i++) {
            int[] tuple = Stream.of(sArr[i].split(",")).mapToInt(Integer::parseInt).toArray();
            for (int num : tuple) {
                if (!dup.contains(num)) {
                    result.add(num);
                }
                dup.add(num);
            }
        }
 
        int[] answer = new int[result.size()];
 
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
 
        return answer;
    }
}