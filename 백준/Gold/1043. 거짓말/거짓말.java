import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		boolean[] truthParty = new boolean[m+1];
		boolean[] truthPpl = new boolean[n+1];
		List<Integer>[] parties = new ArrayList[m+1];
		List<Integer>[] people = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) {
			people[i] = new ArrayList<>();
		}
		for(int i = 1; i <= m; i++) {
			parties[i] = new ArrayList<>();
		}
		Queue<Integer> q = new LinkedList<>();
		int answer = m;
		s = br.readLine().split(" ");
		for(int i = 1; i < s.length; i++) {
			q.add(Integer.parseInt(s[i]));
		}
		for(int i = 1; i <= m; i++) {
			s = br.readLine().split(" ");
			for(int j = 1; j < s.length; j++) {
				int p = Integer.parseInt(s[j]);
				parties[i].add(p);
				people[p].add(i);
			}
		}
		while(!q.isEmpty()) {
			int now = q.poll();
			if(!truthPpl[now]) {
				truthPpl[now] = true;
				for(int party : people[now]) {
					if(!truthParty[party]) {
						answer--;
						truthParty[party] = true;
						for(int next : parties[party]) {
							if(!truthPpl[next]) {
								q.offer(next);
							}
						}
					}
				}
			}
			
		}
		System.out.println(answer);
	}
}