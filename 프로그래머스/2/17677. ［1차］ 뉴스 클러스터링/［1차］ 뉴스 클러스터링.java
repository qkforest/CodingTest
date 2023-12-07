import java.util.*;
import java.util.regex.Pattern;
import java.util.Map.Entry;
class Solution {
    public int solution(String str1, String str2) {
        int sum = 0, same = 0;
        String temp = "";
        //str1 = str1.replaceAll("[^a-zA-Z]", "").toLowerCase();
        //str2 = str2.replaceAll("[^a-zA-Z]", "").toLowerCase();
        Map<String, Integer> s1 = new HashMap<>(), s2 = new HashMap<>();
        for(int i = 0; i < str1.length()-1; i++){
            if(Pattern.matches("^[a-zA-Z]*$", str1.substring(i, i+2))){
                temp = str1.substring(i, i+2).toLowerCase();
                if(s1.containsKey(temp))
                    s1.put(temp, s1.get(temp)+1);
                else
                    s1.put(temp, 1);
            }
        }
        for(int i = 0; i < str2.length()-1; i++){
            if(Pattern.matches("^[a-zA-Z]*$", str2.substring(i, i+2))){
                temp = str2.substring(i, i+2).toLowerCase();
                if(s2.containsKey(temp))
                    s2.put(temp, s2.get(temp)+1);
                else
                    s2.put(temp, 1);
            }
        }
        Iterator<Entry<String, Integer>> it = s1.entrySet().iterator();
        while(it.hasNext()){            
            Entry<String, Integer> entrySet = (Entry<String, Integer>) it.next();
            if(s2.containsKey(entrySet.getKey())){
                if(s2.get(entrySet.getKey()) < entrySet.getValue()){
                    same += s2.get(entrySet.getKey());
                    s2.put(entrySet.getKey(), entrySet.getValue());
                } else
                    same += entrySet.getValue();
            } else
                s2.put(entrySet.getKey(), entrySet.getValue());     
         }
        for(int n : s2.values())
            sum += n;
        if(sum == 0 && same == 0)
            return 65536;
        else
            return (int)Math.floor((same/(float)sum) * (float)65536);
    }
}