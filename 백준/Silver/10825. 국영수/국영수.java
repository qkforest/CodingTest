import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] names = new String[N];
		Map<String, Scores> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			names[i] = s[0];
			map.put(s[0], new Scores(Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3])));
		}
		Arrays.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				Scores s1 = map.get(o1);
				Scores s2 = map.get(o2);
				if(s1.korean == s2.korean) {
					if(s1.english == s2.english) {
						if(s1.math == s2.math) {
							return o1.compareTo(o2);
						}
						return Integer.compare(s2.math, s1.math);
					}
					return Integer.compare(s1.english, s2.english);
				}
				return Integer.compare(s2.korean, s1.korean);
			}
		});
		StringBuilder sb = new StringBuilder();
		for(String name : names) {
			sb.append(name).append("\n");
		}
		System.out.print(sb);
	}
	
	static class Scores {
		int korean;
		int english;
		int math;
		
		public Scores(int korean, int english, int math) {
			this.korean = korean;
			this.english = english;
			this.math = math;
		}
	}
}