import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] len = new int[N];
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			len[i] = 1;
			for(int j = i-1; j >= 0; j--) {
				if(A[i] > A[j]) {
					len[i] = Math.max(len[i], len[j]+1);
				}
			}
			answer = Math.max(answer, len[i]);
		}
		
		System.out.println(answer);
	}
}