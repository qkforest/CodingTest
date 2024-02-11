import java.util.*;
class Solution {
    public List<String> exp;
    public boolean[] visited;
    public String[] temp;
    public long answer;
    public long solution(String expression) {
        answer = 0;
        exp = new ArrayList<>();
        Set<String> op = new HashSet<>();
        String num = "";
        for(char e : expression.toCharArray()){
            if(Character.isDigit(e)) num += e;
            else{
                exp.add(num);
                num = "";
                String operator = String.valueOf(e);
                exp.add(operator);
                op.add(operator);
            }
        }
        exp.add(num);
        String[] arr = op.toArray(new String[0]);
        visited = new boolean[arr.length];
        temp = new String[arr.length];
        dfs(0, op.size(), arr);
        return answer;
    }
    public void dfs(int level, int size, String[] arr){
        if(level == size){
            List<String> copy = new ArrayList<>(exp);
            for(String s : temp){
                for(int i = 0; i < copy.size(); i++){
                    long a = 0;
                    if(copy.get(i).equals(s)){
                        switch(s){
                            case "-": 
                                a = Long.valueOf(copy.get(i-1)) - Long.valueOf(copy.get(i+1));
                                copy.set(i-1, "");
                                copy.set(i, "");
                                copy.set(i+1, String.valueOf(a));
                                break;
                            case "+": 
                                a = Long.valueOf(copy.get(i-1)) + Long.valueOf(copy.get(i+1));
                                copy.set(i-1, "");
                                copy.set(i, "");
                                copy.set(i+1, String.valueOf(a));
                                break;
                            case "*": 
                                a = Long.valueOf(copy.get(i-1)) * Long.valueOf(copy.get(i+1));
                                copy.set(i-1, "");
                                copy.set(i, "");
                                copy.set(i+1, String.valueOf(a));
                                break;  
                        }
                    }
                }
                while (copy.remove("")) {        
                };
            }
            long result = Math.abs(Long.valueOf(copy.get(0)));
            if(result > answer) answer = result;
        }else{
            for(int i = 0; i < size; i++){
                if(!visited[i]){
                    visited[i] = true;
                    temp[level] = arr[i];
                    dfs(level+1, size, arr);
                    visited[i] = false;
                }
            }
        }
    }
}