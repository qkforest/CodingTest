import java.io.*;

class Main{
	public static int findCases(int N) {
		int count = 0; // 합이 N이 되는 경우의 수
		int left = 1;
		int right = 1;
		int sum = 0;
		while(right <= N+1) {
			if(sum < N) {
				sum += right++;
			} else {
				if(sum == N) {
					count++;
				}
				sum -= left++;
			}
		}
		return count;
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.print(findCases(N));
	}
}