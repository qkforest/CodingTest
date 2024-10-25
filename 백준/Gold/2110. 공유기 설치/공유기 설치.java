import java.util.*;
import java.io.*;

class Main {
	public static int N, C;
	public static int[] house;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		house = new int[N];
		for(int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);
		int left = 1;
		int right = house[N-1];
		int answer = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(search(mid) < C) {
				right = mid - 1;
			} else {
				answer = mid;
				left = mid + 1;
			}
		}
		System.out.print(answer);
	}
	public static int search(int dist) {
		int count = 1;
		int pre = house[0];
		for(int i = 0; i < N; i++) {
			if(house[i] - pre >= dist) {
				pre = house[i];
				count++;
			}
		}
		return count;
	}
}