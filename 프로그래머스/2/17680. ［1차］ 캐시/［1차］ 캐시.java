import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0)
            answer = 5 * cities.length;
        else {
            LinkedList<String> cache = new LinkedList<>();
            for(String city : cities){
                city = city.toLowerCase();
                if(cache.size() >= cacheSize){
                    if(cache.contains(city)){
                        answer += 1;
                        cache.remove(cache.indexOf(city));
                        cache.add(city);
                    } else {
                        answer += 5;
                        cache.removeFirst();
                        cache.add(city);
                    }
                } else{
                    if(cache.contains(city)){
                        answer += 1;
                        cache.remove(cache.indexOf(city));
                        cache.add(city);
                    } else{
                        cache.add(city);
                        answer += 5;
                    }
                }
            }
        }
        return answer;
    }
}