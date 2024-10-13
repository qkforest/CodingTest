import java.io.*;
import java.util.*;

class Main {
	public static int[] gates;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Member[] members = new Member[N];
		for(int i = 0; i < N; i++) {
			String[] m = br.readLine().split(" ");
			members[i] = new Member(i, Integer.parseInt(m[0]), m[1]);
		}
		Arrays.sort(members);
		StringBuilder sb = new StringBuilder();
		for(Member m : members) {
			sb.append(m.age).append(" ").append(m.name).append("\n");
		}
		System.out.print(sb);
	}
	
	public static class Member implements Comparable<Member> {
		int index;
		int age;
		String name;
		
		public Member(int index, int age, String name) {
			this.index = index;
			this.age = age;
			this.name = name;
		}
		
		public int compareTo(Member other) {
			if(this.age == other.age) {
				return Integer.compare(this.index, other.index);
			}
			return Integer.compare(this.age, other.age);
		}
	}
}