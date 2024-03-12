import java.util.*;
class Solution {
    static int answer = 0;
    static int[] Info;
    static ArrayList<Integer>[] childs;
    public int solution(int[] info, int[][] edges) {
        Info = info;
        childs = new ArrayList[info.length];
        for(int[] e: edges){
            int p = e[0];
            int c = e[1];
            if(childs[p] == null)
                childs[p] = new ArrayList<>();
            childs[p].add(c);
        }
        List<Integer> list = new ArrayList<>();
		list.add(0);
		dfs(0, 0, 0, list);
        return answer;
    }
    public void dfs(int idx, int wolf, int sheep, List<Integer> list){
        if(Info[idx] == 0)
            sheep++;
        else
            wolf++;
        if(sheep <= wolf)
            return;
        answer = Math.max(answer, sheep);
        List<Integer> next = new ArrayList<>();
		next.addAll(list);
        next.remove(Integer.valueOf(idx));
        if(childs[idx] != null){
            for(int c : childs[idx])
                next.add(c);
        }
        for(int n : next)
            dfs(n, wolf, sheep, next);
    }
}