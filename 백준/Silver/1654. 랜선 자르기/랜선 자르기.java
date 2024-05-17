import java.io.*;
public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int K = Integer.parseInt(s[0]);
		int N = Integer.parseInt(s[1]);
		long [] lans = new long[K];
		long max = 0;
		for(int i = 0; i < K; i++) {
			lans[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, lans[i]);
		}
		System.out.println(binarySearch(lans, max, N));
	}
	public static long binarySearch(long[] lans, long max, int N) {
		long result = 0;
		long left = 1;
		long right = max;
		while(left <= right) {
			long mid = (left + right)/ 2;
			long count = 0;
			for(long l : lans) {
				count += (l / mid);
			}
			if(count >= N) {
				left = mid + 1;
				result = Math.max(result, mid);
			}
			else {
				right = mid - 1;
			}
		}
		return result;
	}
}