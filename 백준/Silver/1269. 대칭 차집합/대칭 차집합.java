import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		Set<Integer> A = new HashSet<>();
		Set<Integer> B = new HashSet<>();
		s = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			A.add(Integer.parseInt(s[i]));
		}
		s = br.readLine().split(" ");
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(s[i]);
			if(A.contains(num)) {
				A.remove(num);
			} else {
				B.add(num);
			}
		}
		System.out.print(A.size()+B.size());
	}
}