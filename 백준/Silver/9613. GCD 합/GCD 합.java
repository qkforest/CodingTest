import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			long answer = 0;
			for(int j = 1; j < num[0]; j++) {
				for(int k = j+1; k < num[0]+1; k++) {
					answer += gcd(num[k], num[j]);
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}
	public static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}