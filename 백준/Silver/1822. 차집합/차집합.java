import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine().split(" ");
		Set<Integer> A = new TreeSet<>();
		Set<Integer> B = new TreeSet<>();
		String[] s = br.readLine().split(" ");
		for(String t : s) {
			A.add(Integer.parseInt(t));
		}
		s = br.readLine().split(" ");
		for(String t : s) {
			B.add(Integer.parseInt(t));
		}
		A.removeAll(B);
		System.out.println(A.size());
		if(A.size() > 0) {
			StringBuilder sb = new StringBuilder();
			for(int t : A) {
				sb.append(t + " ");
			}
			sb.deleteCharAt(sb.length()-1);
			System.out.print(sb);
		}
	}
}