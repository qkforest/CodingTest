import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] len = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(len);
		int answer = len[0]+len[1];
		if(answer > len[2]) {
			sb.append(answer+len[2]);
		} else {
			sb.append(answer*2-1);
		}
		System.out.print(sb);
	}
}