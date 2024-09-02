import java.io.*;
import java.util.Arrays;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int x = Integer.parseInt(br.readLine());
		int answer = 0;
		Arrays.sort(arr);
		
		for(int i = 0; i < n-2; i++) {
			int end = n-1;
			int start = i+1;
			while(start <= end) {
				int mid = (start + end) / 2;
				if(arr[i] + arr[mid]>= x) {
					if(arr[i] + arr[mid] == x) {
						answer++;
					}
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		
		System.out.print(answer);
	}
	
}