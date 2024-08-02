import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		PriorityQueue<Seq> pq = new PriorityQueue<>();
		int answer = 1;
		for(String s : str) {
			int num = Integer.parseInt(s);
			List<Seq> temp = new ArrayList<>();
			boolean newSeq = true;
			while(!pq.isEmpty()) {
				Seq pre = pq.poll();
				temp.add(pre);
				if(pre.last <= num) {
					continue;
				} else {
					int l = pre.len + 1 ;
					pq.offer(new Seq(num, l));
					answer = Math.max(answer, l);
					newSeq = false;
					break;
				}
			}
			for(Seq add: temp) {
				pq.offer(add);
			}
			if(newSeq) {
				pq.offer(new Seq(num, 1));
			}
		}
		System.out.print(answer);
	}
	static class Seq implements Comparable<Seq> {
		int last;
		int len;
		
		public Seq(int last, int len) {
			this.last = last;
			this.len = len;
		}
		
		@Override
		public int compareTo(Seq other) {
			if(this.len == other.len) {
				return other.last - this.last;
			}
			return other.len - this.len;
		}
	}
}