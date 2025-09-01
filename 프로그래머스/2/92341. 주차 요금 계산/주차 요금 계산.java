import java.util.*;

class Solution {
    private static Map<String, Integer> time, inOut;
    private int count(String car, int[] fees) {
        int t = time.get(car);
        int fee = fees[1];
        t -= fees[0];
        if(t > 0) {
            fee += t / fees[2] * fees[3];
            if(t % fees[2] > 0) {
                fee += fees[3];
            }
        }
        return fee;
    }
    public int[] solution(int[] fees, String[] records) {
        time = new HashMap<>();
        inOut = new HashMap<>();
        for(String r : records) {
            String[] arr = r.split(" ");
            String[] t = arr[0].split(":");
            int n = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            if(inOut.containsKey(arr[1])) {
                time.merge(arr[1], n - inOut.get(arr[1]), Integer::sum);
                inOut.remove(arr[1]);
            } else {
                inOut.put(arr[1], n);
            }
        }
        for(String car : inOut.keySet()) {
            time.merge(car, 1439 - inOut.get(car), Integer::sum);
        } 
        List<String> list = new ArrayList<>(time.keySet());
        Collections.sort(list);
        return list.stream().mapToInt(car -> count(car, fees)).toArray();
    }
}