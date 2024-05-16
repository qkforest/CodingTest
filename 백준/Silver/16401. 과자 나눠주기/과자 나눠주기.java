import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int M = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		int[] snacks = new int[N+1];
		int max = 0;
		s = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			snacks[i] = Integer.parseInt(s[i]);
			max = Math.max(max, snacks[i]);
		}
		System.out.println(binarySearch(snacks, M, max));
	}
	public static int binarySearch(int[] snacks, int M, int max) {
		int result = 0;
		int left = 1;
		int right = max;
		while(left <= right) {
			int mid = (left + right) / 2;
			int cnt = 0;
			for(int s : snacks) {
				cnt += s/mid;
			}
			if(cnt >= M) {
				result = Math.max(result, mid);
				left = mid + 1;
			} 
			else {
				right = mid - 1;
			}
		}
		return result;
	}
}