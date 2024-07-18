import java.io.*;

class Main{
	public static int findCases(int N, int M, long[] sums) {
		int count = 0;
		for(int i = 1; i <= N; i++) {
			int left = 0;
			int right = i;
			while(left <= right) {
				int mid = (left + right) / 2;
				long sum = sums[i] - sums[mid];
				if(sum == M) {
					count++;
					break;
				}
				else if(sum > M) {
					left = mid + 1;
				}
				else {
					right = mid - 1;
				}
			}
		}
		return count;
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		long[] sums = new long[N+1];
		str = br.readLine().split(" ");
		sums[1] = Integer.parseInt(str[0]);
		
		for(int i = 2; i <= N; i++) {
			sums[i] = Long.parseLong(str[i-1]) + sums[i-1];
		}
		
		System.out.print(findCases(N, M, sums));
	}
}