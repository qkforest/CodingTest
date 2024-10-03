import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] answer = new int[N];
		int count = 0;
		for(int num : arr) {
			if(count == 0 || answer[count-1] < num) {
				answer[count] = num;
				count++;
			} else {
				int left = 0;
				int right = count - 1;
				while(left < right) {
					int mid = (left + right) / 2;
					if(answer[mid] < num) {
						left = mid + 1;
					} else {
						right = mid;
					}
				}
				answer[left] = num;
			}
		}
		System.out.println(count);
	}
}