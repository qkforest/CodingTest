import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		Integer[] B = new Integer[N];
		String[] s = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(s[i]);
		}
		Arrays.sort(A);
		s = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(s[i]);
		}
		Arrays.sort(B, (a, b) -> b - a);
		int answer = 0;
		for(int i = 0; i < N; i++) {
			answer += A[i] * B[i];
		}
		System.out.println(answer);
	}
}