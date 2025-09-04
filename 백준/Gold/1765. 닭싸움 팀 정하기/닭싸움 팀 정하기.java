import java.util.*;
import java.io.*;

class Main {
	private static int[] friends;
	private static List<Integer>[] enemies;
	
	private static int find(int a) {
		if(friends[a] == a) {
			return a;
		}
		return friends[a] = find(friends[a]);
	}
	
	private static void union(int a, int b) {
		int aFriend = find(a);
		int bFriend = find(b);
		if(aFriend == bFriend) {
			return;
		}
		if(aFriend < bFriend) {
			friends[bFriend] = aFriend;
		} else {
			friends[aFriend] = bFriend;
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		friends = new int[n+1];
		enemies = new ArrayList[n+1];
		Set<Integer> set = new HashSet<>();
		
		for(int i = 1; i <= n; i++) {
			friends[i] = i;
			enemies[i] = new ArrayList<>();	
		}
		
		for(int i = 0; i < m; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[1]);
			int b = Integer.parseInt(s[2]);
			if(s[0].equals("F")) {
				union(a, b);
			} else {
				enemies[a].add(b);
				enemies[b].add(a);
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int e : enemies[i]) {
				for(int f : enemies[e]) {
					union(i ,f);
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			friends[i] = find(friends[i]);
			set.add(friends[i]);
		}
				
		System.out.print(set.size());
	}
}