import java.util.*;

class Solution {
    private Map<String, List<Integer>> map;
    private int score;
    private void buildMap(String[] arr, int level, String temp) {
        if(level == 4) {
            map.computeIfAbsent(temp, k -> new ArrayList<>()).add(Integer.parseInt(arr[4]));
            return;
        }
        buildMap(arr, level+1, temp+"-");
        buildMap(arr, level+1, temp+arr[level]);
    }
    private int binarySearch(List<Integer> list) {
        int l = 0;
        int r = list.size() - 1;
        while(l < r) {
            int mid = (l + r) / 2;
            if(list.get(mid) < score) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if(list.get(l) < score) {
            return 0;
        }
        return list.size() - l;
    }
    public int[] solution(String[] info, String[] query) {
        map = new HashMap<>();
        for(String i : info) {
            String[] arr = i.split(" ");
            buildMap(arr, 0, "");
        }
        for(List<Integer> list : map.values()) {
            Collections.sort(list);
        }
        int[] answer = new int[query.length];
        for(int i = 0; i < answer.length; i++) {
            String[] arr = query[i].split(" (and )?");
            String key = String.join("", Arrays.copyOf(arr, arr.length - 1));
            score = Integer.parseInt(arr[arr.length - 1]);
            if(!map.containsKey(key)) {
                continue;
            }
            answer[i] = binarySearch(map.get(key));
        }
        return answer;
    }
}