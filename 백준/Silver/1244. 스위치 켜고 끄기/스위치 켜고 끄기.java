import java.io.*;
import java.util.*;

class Main {
	public static int[] switches;
	public static int N;
 	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 스위치 수
		switches = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 스위치 초기 상태
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			String[] s = br.readLine().split(" ");
			switch(s[0]) {
			case "1" :
				male(Integer.parseInt(s[1]));
				break;
			case "2" :
				female(Integer.parseInt(s[1]));
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(switches[i-1]);
			if(i % 20 == 0) {
				sb.append("\n");
			}
			else {
				sb.append(" ");
			}
		}
		System.out.print(sb);
 	}
 	public static void male(int idx) {
 		int m = 1;
 		while(idx * m - 1 < N) {
 			int i = idx * m++ - 1;
 			switches[i] = (switches[i] == 0) ? 1 : 0;
 		}
 	}
	public static void female(int idx) {
	 	int left = idx - 2;
	 	int right = idx;
	 	while(left >= 0 && right < N && switches[left] == switches[right]) {
	 		int change = (switches[left] == 0) ? 1 : 0;
	 		switches[left--] = change;
	 		switches[right++] = change;
	 	}
	 	switches[idx-1] = (switches[idx-1] == 0) ? 1 : 0;
	 }
}