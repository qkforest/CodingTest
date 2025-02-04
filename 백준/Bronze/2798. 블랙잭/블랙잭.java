import java.io.*;
import java.util.*;
class Main {
	public static int answer, N, M;
	public static int[] arr;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		answer = 0;
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		find(0, 0, 0);
		System.out.print(answer);
	}
	public static void find(int level, int start, int temp) {
		if(level == 3) {
			if(temp <= M) {
				answer = Math.max(temp, answer);
			}
			return;
		}
		for(int i = start; i < arr.length; i++) {
			find(level+1, i+1, temp+arr[i]);
		}
	}
}