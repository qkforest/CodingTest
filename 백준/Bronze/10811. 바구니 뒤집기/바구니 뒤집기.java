import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = i+1;
		}
		for(int k = 0; k < M; k++) {
			s = br.readLine().split(" ");
			int i = Integer.parseInt(s[0]) - 1;
			int j = Integer.parseInt(s[1]) - 1;
			int left = i - 1 + (j-i+1) / 2;
			int right = left + 1;
			if((j-i+1) % 2 != 0) {
				right++;
			}
			while(left >= i && right <= j) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left--;
				right++;
			}
		}
		for(int n : arr) {
			sb.append(n).append(" ");
		}
		System.out.print(sb);
	}
}