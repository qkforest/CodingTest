import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[5];
		for(int i = 0; i < 5; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		int mean = 0;
		for(int n : arr) {
			mean += n;
		}
		System.out.println(mean/5);
		System.out.print(arr[2]);
	}
}