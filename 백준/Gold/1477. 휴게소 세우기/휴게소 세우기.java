import java.io.*;
import java.util.*;

class Main {
	public static int N, M, L;
	public static int[] rest;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		L = Integer.parseInt(s[2]);
		rest = new int[N+2];
		rest[0] = 0;
		rest[1] = L;
		s = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			rest[i+2] = Integer.parseInt(s[i]);
		}
		Arrays.sort(rest);
		int left = 1;
		int right = L;
		int answer = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(search(mid) <= M) {
				answer = mid;
				right = mid - 1;
			} else {			
				left = mid + 1;
			}
		}
		System.out.print(answer);
	}
	public static int search(int dist) {
		int count = 0;
		for(int i = 1; i < N+2; i++) {
			if(rest[i] - rest[i-1] > dist) {
				count += (rest[i] - rest[i-1]) / dist;
				if((rest[i] - rest[i-1]) % dist == 0) {
					count--;
				}
			}
		}
		return count;
	}
}