import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		Set<Integer> A = new HashSet<>();
		s = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			A.add(Integer.parseInt(s[i]));
		}
		int a = N;
		int b = M;
		s = br.readLine().split(" ");
		for(int i = 0; i < M; i++) {
			if(A.contains(Integer.parseInt(s[i]))) {
				a--;
				b--;
			}
		}
		System.out.print(a+b);
	}
}