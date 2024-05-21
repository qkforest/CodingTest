import java.io.*;
import java.util.*;
class Solution
{
    public static int count, answer;
    public static char[] num;
  
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        for(int t = 1; t <= testcase; t++) {
            String[] s = br.readLine().split(" ");
            num = s[0].toCharArray();
            count = Math.min(Integer.parseInt(s[1]), num.length);
            answer = 0;
            dfs(0, 0);
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ").append(answer);
            System.out.println(sb);
        }
	}
    public static void dfs(int start, int level){
        if(count == level) {
        	String result = String.valueOf(num);
        	answer = Math.max(answer, Integer.parseInt(result));
            return;
        }
        for (int i = start; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                char temp = num[i];
                num[i] = num[j];
                num[j] = temp;
                dfs(i, level + 1);
                temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
        }
    }
}