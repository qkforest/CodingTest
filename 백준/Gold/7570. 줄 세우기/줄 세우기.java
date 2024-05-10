import java.io.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] arr = new int[N+1];
		int[] pos = new int[N+1];
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(s[i-1]);
			pos[arr[i]] = i;
		}
		int answer = 0;
		for(int i = 1; i <= N; i++) {
			int len = 1;
			int now = arr[i];
			while(now < N){
				if(pos[now] > pos[now+1]) {
					break;
				}
				now++;
				len++;
			}
			answer = Math.max(answer, len);
		}
		System.out.println(N-answer);
	}
}