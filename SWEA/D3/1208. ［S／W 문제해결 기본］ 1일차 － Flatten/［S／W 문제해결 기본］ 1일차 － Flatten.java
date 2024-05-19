import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case = 1; test_case <= 10; test_case++) {
			int dump = Integer.parseInt(br.readLine());
			int[] boxes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			while(dump > 0) {
				Arrays.sort(boxes);
				if(boxes[99] - boxes[0] <= 1) {
					break;
				}
				boxes[99]--;
				boxes[0]++;
                dump--;
			}
			int max = Arrays.stream(boxes).max().getAsInt();
			int min = Arrays.stream(boxes).min().getAsInt();
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(max - min).append("\n");
			System.out.print(sb);
 		}
	}
}
