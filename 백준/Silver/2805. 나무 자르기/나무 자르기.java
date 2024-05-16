import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int[] trees = new int[N];
		int max = 0;
		s = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(s[i]);
			max = Math.max(max, trees[i]);
		}
		System.out.println(binarySearch(trees, max, M));
	}
	public static int binarySearch(int[] trees, int max, int M) {
		int result = 0;
		int left = 0;
		int right = max;
		while(left <= right) {
			int mid = (left + right) / 2;
			long sum = 0;
			for(int t : trees) {
				if(t > mid) {
					sum += (t - mid);
				}
			}
			if(sum >= M) {
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