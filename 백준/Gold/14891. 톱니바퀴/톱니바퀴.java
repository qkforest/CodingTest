import java.io.*;
import java.util.*;

class Main {
	public static int[][] wheels;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		wheels = new int[4][8];
		for(int i = 0; i < 4; i++) {
			String wheel = br.readLine();
			for(int j = 0; j < 8; j++) {
				wheels[i][j] = wheel.charAt(j) - '0';
			}
		}
		int k  = Integer.parseInt(br.readLine());
		for(int i = 0; i < k; i++) {
			String[] s = br.readLine().split(" ");
			rotate(Integer.parseInt(s[0])-1, Integer.parseInt(s[1]));
		}
		int answer = 0;
		for(int i = 0; i < 4; i++) {
			answer += wheels[i][0] * Math.pow(2, i); 
		}
		System.out.print(answer);	
	}
	public static void rotate(int idx, int d) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {idx, d});
		int next = d;
		for(int i = idx+1; i < 4; i++) {
			next *= (-1);
			if(wheels[i][6] == wheels[i-1][2]) {
				break;
			} else {
				q.offer(new int[] {i, next});
			}
		}
		next = d;
		for(int i = idx-1; i >= 0; i--) {
			next *= (-1);
			if(wheels[i][2] == wheels[i+1][6]) {
				break;
			} else {
				q.offer(new int[] {i, next});
			}
		}
		while(!q.isEmpty()) {
			int[] now = q.poll();
			direction(now[0], now[1]);
		}
	}
	public static void direction(int idx, int d) {
		if(d == 1) {
			clock(idx);
		} else {
			counterclock(idx);
		}
	}
	public static void clock(int idx) {
		int temp = wheels[idx][7];
		for(int i = 7; i >= 1; i--) {
			wheels[idx][i] = wheels[idx][i-1];
		}
		wheels[idx][0] = temp;
	}
	public static void counterclock(int idx) {
		int temp = wheels[idx][0];
		for(int i = 0; i < 7; i++) {
			wheels[idx][i] = wheels[idx][i+1];
		}
		wheels[idx][7] = temp;
	}
}