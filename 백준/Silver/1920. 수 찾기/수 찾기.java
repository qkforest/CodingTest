import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Set<Integer> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			set.add(num[i]);
		}
		int M = Integer.parseInt(br.readLine());
		int[] num2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			int answer = 0;
			if(set.contains(num2[i])) {
				answer = 1;
			}
			sb.append(answer + "\n");
		}
		System.out.print(sb);
	}
}