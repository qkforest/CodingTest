import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] weights = new int[N];
		for(int i = 0; i < N; i++) {
			weights[i] =Integer.parseInt(br.readLine());
		}
		Arrays.sort(weights);
		int answer = 0;
		for(int i = 0; i < N; i++) {
			answer = Math.max(answer, weights[i] * (N-i));
		}
		System.out.println(answer);
	}
}