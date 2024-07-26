import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		Gem[] gems = new Gem[N];
		
		for(int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			gems[i] = new Gem(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
		}
		Arrays.sort(gems);
		int[] bags = new int[K];
		for(int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags);
		
		long answer = 0;
		int idx = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int weight : bags) {
			while(idx < N && gems[idx].weight <= weight) {
				pq.offer(gems[idx++].price);
			}
			if(!pq.isEmpty()) {
				answer += pq.poll();
			}
 		}
		System.out.print(answer);
	}
	static class Gem implements Comparable<Gem> {
		int weight;
		int price;
		
		public Gem(int weight, int price) {
			this.weight = weight;
			this.price = price;
		}
		
		@Override
		public int compareTo(Gem other) {
			return this.weight - other.weight;
		}
	}
}