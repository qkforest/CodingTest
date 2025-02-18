import java.util.*;
import java.io.*;

class Main {
	public static int count, size;
	public static List<Integer> prime;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		prime = new ArrayList<>();
		boolean[] check = new boolean[1000000];
		check[1] = true;
		for(int i = 2; i < 1000000; i++) {
			if(!check[i]) {
				if(isPrime(i)) {
					prime.add(i);
					int m = 2;
					while(m*i < 1000000) {
						check[m*i] = true;
						m++;
					}
				} else {
					check[i] = true;
				}
			}
		}
		size = prime.size();
		for(int i = 0; i < t; i++) {
			count = 0;
			int n = Integer.parseInt(br.readLine());
			int j = 0;
			int a;
			boolean[] visited = new boolean[n];
			while((a=prime.get(j)) < n) {
				int b = n - a;
				if(!check[b] && !visited[b]) {
					visited[a] = true;
					visited[b] = true;
					count++;
				}
				j++;
			}
			sb.append(count).append("\n");
		}
		System.out.print(sb);
	}
	public static boolean isPrime(int n) {
		if(n == 2) {
			return true;
		}
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
}