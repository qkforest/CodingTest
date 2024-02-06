import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        int len = genres.length;
        Map<String, Integer> genreCount = new HashMap<>();
        for(int i = 0; i < len; i++){
            if(!genreCount.containsKey(genres[i])) genreCount.put(genres[i], plays[i]);
            else genreCount.put(genres[i], genreCount.get(genres[i])+plays[i]);
        }
        List<String> keySet = new ArrayList<>(genreCount.keySet());
        keySet.sort((o1, o2) -> genreCount.get(o2).compareTo(genreCount.get(o1)));
        for(String k : keySet){
            Map<Integer, Integer> playCount = new HashMap<>();
            int count = 0;
            for(int i = 0; i < len; i++){
                if(genres[i].equals(k)) playCount.put(i, plays[i]);
            }
            List<Integer> keySet2 = new ArrayList<>(playCount.keySet());
            keySet2.sort((o1, o2) -> playCount.get(o2).compareTo(playCount.get(o1)));
            for(int i : keySet2) {
                if(count == 2) break;
                else {
                    answer.add(i);
                    count++;
                }
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}