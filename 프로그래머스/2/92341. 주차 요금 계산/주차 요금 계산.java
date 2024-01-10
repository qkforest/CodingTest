import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        Map<String, String> rec = new HashMap<>();
        Map<String, Integer> fee = new TreeMap<>();
        String a = "", b = "";
        int charge = 0;
        for(String r : records){
            if(rec.containsKey(r.substring(6, 10))){
                a = rec.get(r.substring(6, 10));
                b = r.substring(0, 5);
                charge = Integer.valueOf(b.substring(3, 5)) - Integer.valueOf(a.substring(3, 5));
                if(charge > 0)
                    charge += (Integer.valueOf(b.substring(0, 2)) - Integer.valueOf(a.substring(0, 2))) * 60;
                else{
                    charge += 60;
                    charge += (Integer.valueOf(b.substring(0, 2)) - 1 - Integer.valueOf(a.substring(0, 2))) * 60;
                }
                if(fee.containsKey(r.substring(6, 10)))
                    fee.put(r.substring(6, 10), fee.get(r.substring(6, 10))+charge);
                else
                    fee.put(r.substring(6, 10), charge);
                rec.remove(r.substring(6, 10));
            } else
                rec.put(r.substring(6, 10), r.substring(0, 5));
        }
        for (String key : rec.keySet()) {
            a = rec.get(key);
            charge = 59 - Integer.valueOf(a.substring(3, 5));
            charge += (23 - Integer.valueOf(a.substring(0, 2))) * 60;
            if(fee.containsKey(key))
                fee.put(key, fee.get(key)+charge);
            else
                fee.put(key, charge);
        }
        for (String key : fee.keySet()){
            charge = fees[1];
            if(fee.get(key) - fees[0] > 0)
                charge += fees[3] * (int) Math.ceil((fee.get(key) - fees[0])/(double)fees[2]);
            answer.add(charge);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}