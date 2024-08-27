import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int v = Integer.parseInt(br.readLine());
		
		int count = 0;
		for(int num : arr) {
			if(num == v) {
				count++;
			}
		}
		
		System.out.print(count);
		
	}
}