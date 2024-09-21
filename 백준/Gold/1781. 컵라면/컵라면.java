import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		long answer = 0;
		List<Problem> problems = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			problems.add(new Problem(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
		}
		Collections.sort(problems);
		for(int i = 0; i < N; i++) {
			Problem p = problems.get(i);
			if(pq.size() < p.deadline) {
				pq.offer(p.ramen);
			} else if(pq.size() == p.deadline) {
				if(pq.peek() < p.ramen) {
					pq.poll();
					pq.offer(p.ramen);
				}
			}
		}
		while(!pq.isEmpty()) {
			answer += pq.poll();
		}
		System.out.print(answer);
	}
	public static class Problem implements Comparable<Problem> {
		int deadline;
		int ramen;
		
		public Problem(int deadline, int ramen) {
			this.deadline = deadline;
			this.ramen = ramen;
		}
		
		public int compareTo(Problem other) {
			if(this.deadline == other.deadline) {
				return Integer.compare(other.ramen, this.ramen);
			}
			return Integer.compare(this.deadline, other.deadline);
		}
	}
}