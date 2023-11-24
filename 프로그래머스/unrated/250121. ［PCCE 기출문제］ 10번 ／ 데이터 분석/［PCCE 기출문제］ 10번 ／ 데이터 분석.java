import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Integer[]> answer = new ArrayList<Integer[]>();
        String[] e = {"code", "date", "maximum", "remain"};
        for(int i = 0; i < data.length; i++){
            if(data[i][Arrays.asList(e).indexOf(ext)] < val_ext)
                answer.add(Arrays.stream(data[i]).boxed().toArray(Integer[]::new));
        }
        Collections.sort(answer, (o1, o2) -> {
            return o1[Arrays.asList(e).indexOf(sort_by)] - o2[Arrays.asList(e).indexOf(sort_by)];
        });
        return answer.stream().map(item -> Arrays.stream(item).mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }
}