import java.util.*;
class Solution {
    static int col, row;
    static Integer[] can;
    static List<String> answer = new ArrayList<>();
    public int solution(String[][] relation) {
        col = relation[0].length;
        row = relation.length;
        for(int i = 1; i <= col; i++){
            can = new Integer[i];
            dfs(0, 0, i, relation);
        }
        return answer.size();
    }
    public void dfs(int start, int level, int len, String[][] relation){
        if(level == len){
            boolean find = true;
            List<String> list = new ArrayList<>();
            for(int i = 0; i < row; i++){
                String[] temp = new String[len];
                for(int idx = 0; idx < len; idx++){
                    temp[idx] = relation[i][can[idx]];
                }
                if(list.contains(Arrays.toString(temp))){
                    find = false;
                    break;
                } else
                    list.add(Arrays.toString(temp));
            }
            if(find){
                int count = 0;
                for(int i = 0; i < answer.size(); i++){
                    boolean include = true;
                    String com1 = answer.get(i).replaceAll(" ", "");
                    com1 = com1.substring(1, com1.length()-1);
                    String[] arr = com1.split(",");
                    for(String a : arr){
                        if(Arrays.asList(can).contains(Integer.valueOf(a))) 
                            continue;
                        else
                            include = false;
                    }
                    if(include)
                        count++;
                    if(count > 0) 
                        break;
                }
                if(count < 1)
                    answer.add(Arrays.toString(can));
            } 
            return;
        }else{
            for(int i = start; i < col; i++){
                can[level] = i;
                dfs(i+1, level+1, len, relation);
            }
        }
    }
}