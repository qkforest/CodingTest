import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 7; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n % 2 != 0) {
				sum += n;
				min = Math.min(n, min);
			}
		}
		if(sum == 0) {
			System.out.print(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}