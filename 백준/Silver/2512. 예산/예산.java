import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		int[] money = new int[N];
		String[] s = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(s[i]);
			max = Math.max(max, money[i]);
		}
		int M = Integer.parseInt(br.readLine());
		System.out.print(binarySearch(money, max, M));
	}
	public static int binarySearch(int[] money, int max, int M) {
		int result = 0;
		int left = 1;
		int right = max;
		while(left <= right) {
			int mid = (left + right) / 2;
			long sum = 0;
			for(int m : money) {
				if(mid > m) {
					sum += m;
				} else {
					sum += mid;
				}
			}
			if(sum <= M) {
				left = mid + 1;
				result = Math.max(result, mid);
			} else {
				right = mid - 1;
			}
		}
		return result;
	}
}