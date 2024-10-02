import java.util.*;
import java.io.*;

class Main {
	public static int[] parents;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int V = Integer.parseInt(s[0]);
		int E = Integer.parseInt(s[1]);
		Edge[] edges = new Edge[E];
		parents = new int[V];
		for(int i = 0; i < V; i++) {
			parents[i] = i;
		}
		for(int i = 0; i < E; i++) {
			s = br.readLine().split(" ");
			edges[i] = new Edge(Integer.parseInt(s[0])-1, Integer.parseInt(s[1])-1, Integer.parseInt(s[2]));
		}
		Arrays.sort(edges);
		long answer = 0;
		for(int i = 0; i < E; i++) {
			int a = edges[i].a;
			int b = edges[i].b;
			int c = edges[i].cost;
			if(union(a, b)) {
				answer += c;
			}
		}
		System.out.print(answer);
	}
	static class Edge implements Comparable<Edge> {
		int a;
		int b;
		int cost;
		
		public Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
		
		public int compareTo(Edge other) {
			return Integer.compare(this.cost, other.cost);
		}
	}
	
	public static int find(int n) {
		if(parents[n] == n) {
			return n;
		}
		return parents[n] = find(parents[n]);
	}
	
	public static boolean union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		if(parentA == parentB) {
			return false;
		}
		if(parentA < parentB) {
			parents[parentB] = parentA;
		} else {
			parents[parentA] = parentB;
		}
		return true;
	}
}