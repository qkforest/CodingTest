import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int left = 1;
		int right = k;
		
		while(left < right) {
			int mid = (left + right) / 2;
			int count = 0;
			for(int i = 1; i <= N; i++) {
				count += Math.min(mid / i, N);
			}
			if(k <= count) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		System.out.print(left);
	}
}