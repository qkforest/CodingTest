import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		
		LinkedList<Integer> deque = new LinkedList<Integer>();
		for(int i = 1; i <= n; i++) {
			deque.offer(i);
		}
	
		s = br.readLine().split(" ");
		
		int count = 0;
		
		for(String find : s) {
			int target = deque.indexOf(Integer.parseInt(find));
			int mid = deque.size() / 2 ;
			
			if(deque.size() % 2 == 0) {
				mid -= 1;
			}
	
			if(target <= mid) {
				for(int i = 0; i < target; i++) {
					deque.offerLast(deque.pollFirst());
					count++;
				}
			} else {
				for(int i = 0; i < deque.size() - target; i++) {
					deque.offerFirst(deque.pollLast());
					count++;
				}
			}
			deque.poll();
		}
		
		System.out.println(count);
	}
}