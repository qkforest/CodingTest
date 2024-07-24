import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}
		StringBuilder sb = new StringBuilder("<");
		int temp = 1;
		while(!q.isEmpty()) {
			while(temp < K) {
				q.offer(q.poll());
				temp++;
			}
			sb.append(q.poll()).append(", ");
			temp = 1;
		}
		sb.delete(sb.length()-2, sb.length()).append(">");
		System.out.print(sb);
	}
}