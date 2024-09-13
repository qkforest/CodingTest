import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			long answer = 1;
			Map<Integer, Integer> mapA = find(a);
			Map<Integer, Integer> mapB = find(b);
			for(int key : mapB.keySet()) {
				int v = mapB.get(key);
				if(!mapA.containsKey(key)) {
					mapA.put(key, v);
				}
				else if(mapA.get(key) < v) {
					mapA.put(key, v);
				}
			}
			for(int key : mapA.keySet()) {
				answer *= Math.pow(key, mapA.get(key));
			}
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}
	public static Map find(int n) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int d = 2; d <= n; d++) {
			if(n % d == 0 && isPrime(d)) {
				int count = 0;
				while(n % d == 0) {
					n /= d;
					count++;
				}
				map.put(d, count);
			}
		}
		return map;
	}
	public static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) 
				return false;
		}
		return true;
	}
}