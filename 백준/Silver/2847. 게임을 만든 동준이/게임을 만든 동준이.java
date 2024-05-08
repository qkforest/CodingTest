import java.io.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] scores = new int[N];
		for(int i = 0; i < N; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}
		int answer = 0;
		for(int i = N-2; i >= 0; i--) {
			if(scores[i] < scores[i+1]) {
				continue;
			} else {
				answer += Math.abs(scores[i+1] - scores[i]) + 1;
				scores[i] = scores[i+1] - 1;
			}
		}
		System.out.println(answer);
	}
}