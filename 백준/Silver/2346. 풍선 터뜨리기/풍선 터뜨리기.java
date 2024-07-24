import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		Deque<int[]> balloons = new ArrayDeque<>();
		for(int i = 0; i < N; i++) {
			balloons.offer(new int[] {Integer.parseInt(s[i]), i+1, 1});
		}
		StringBuilder sb = new StringBuilder("");
		int move = 0;
		while(!balloons.isEmpty()) {
			if(move > 0) {
				while(move > 1) {
					 balloons.offer(balloons.poll());
					 move--;
				}
			}
			else {
				while(move < 0) {
					 balloons.addFirst(balloons.pollLast());
					 move++;
				}
			}
			int[] remove = balloons.poll();
			sb.append(remove[1]).append(" ");
			move = remove[0];
		}
		System.out.print(sb);
	}
}