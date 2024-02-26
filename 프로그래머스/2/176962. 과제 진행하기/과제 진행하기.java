import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        int num = plans.length;
        List<String> answer = new ArrayList<>();
        Stack<int[]> plan = new Stack<>();
        Stack<int[]> prog = new Stack<>();
        Arrays.sort(plans, (o1, o2) -> o1[1].compareTo(o2[1]));
        for(int i = num-1; i >= 0; i--){
            int start = Integer.parseInt(plans[i][1].substring(0, 2)) * 60 + Integer.parseInt(plans[i][1].substring(3, 5));
            plan.add(new int[]{i, start, Integer.parseInt(plans[i][2])});
        }
        int[] now, pre;
        int start = 0;
        while(!plan.isEmpty()||!prog.isEmpty()){
            if(!plan.isEmpty()){
                now = plan.pop();
                while(!prog.isEmpty()){
                    pre = prog.pop();
                    if(start + pre[1] <= now[1]){
                        answer.add(plans[pre[0]][0]);
                        start = start + pre[1];
                    }
                    else{
                        prog.add(new int[]{pre[0], start + pre[1] - now[1]});
                        break;
                    }
                }
                prog.push(new int[]{now[0], now[2]});
                start = now[1];
            } else{
                pre = prog.pop();
                answer.add(plans[pre[0]][0]);
            }
        }
        return answer.toArray(new String[num]);
    }
}