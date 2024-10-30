import java.util.*;
import java.io.*;

class Main {
	public static int L;
	public static Set<Character> vowel = Set.of('a', 'e', 'i', 'o', 'u');
	public static List<Character> v, c;
	public static Map<Integer, List<String>> map;
	public static PriorityQueue<String> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		L = Integer.parseInt(s[0]);
		s = br.readLine().split(" ");

		v = new ArrayList<>();
		c = new ArrayList<>();
		
		for(String a : s) {
			char al = a.charAt(0);
			if(!vowel.contains(al)) {
				c.add(al);
			} else {
				v.add(al);
			}
		}
		
		map = new HashMap<>();
		Collections.sort(v);
		Collections.sort(c);
		dfs_v(0, 0, new StringBuilder());
		
		StringBuilder answer = new StringBuilder();
		pq = new PriorityQueue<>();
		dfs_c(0, 0, new StringBuilder());
		while(!pq.isEmpty()) {
			answer.append(pq.poll()).append("\n");
		}
		System.out.print(answer);
	}
	public static void dfs_v(int start, int level, StringBuilder sb) {
		if(level == L-2) {
			return;
		}
		for(int i = start; i < v.size(); i++) {
			sb.append(v.get(i));
			map.computeIfAbsent(level+1, k -> new ArrayList<>()).add(sb.toString());
			dfs_v(i+1, level+1, sb);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	public static void dfs_c(int start, int level, StringBuilder sb){
		if(level == L-1) {
			return;
		}
		for(int i = start; i < c.size(); i++) {
			sb.append(c.get(i));
			if(level >= 1) {
				password(sb.toString());
			}
			dfs_c(i+1, level+1, sb);
			sb.deleteCharAt(sb.length()-1);
		}
	}
	public static void password(String s) {
		int len = s.length();
		if(L-len < 1 || !map.containsKey(L-len)) {
			return;
		}
		for(String str : map.get(L-len)) {
			StringBuilder temp = new StringBuilder(s);
			char[] arr = temp.append(str).toString().toCharArray();
			Arrays.sort(arr);
			pq.offer(String.valueOf(arr));
		}
	}
}