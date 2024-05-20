import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] level = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int answer = 0;
			StringBuilder sb = new StringBuilder();
			for(int i = 2; i < N - 2; i++) {
				int leftMax = Math.max(level[i-1], level[i-2]);
				int rightMax = Math.max(level[i+1], level[i+2]);
				int max = Math.max(leftMax, rightMax);
				if(level[i] > max) {
					answer += level[i] - max;
				}
			}
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
			System.out.print(sb);
 		}
	}

}
