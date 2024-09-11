import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int m = arr[0] % 15 == 0 ? 1 : 0;
		int answer;
		while(true) {
			answer = m * 15 + (arr[0] % 15);
			if(answer % 15 == arr[0] % 15 && answer % 28 == arr[1] % 28 && answer % 19 == arr[2] % 19) {
				break;
			}
			m++;
		}
		System.out.print(answer);
	}
}