import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		for(int i = 0; i < 3; i++) {
			int a = Integer.parseInt(br.readLine());
			sum += a;
			set.add(a);
		}
		if(sum != 180) {
			sb.append("Error");
		} else {
			if(set.size() == 1) {
				sb.append("Equilateral");
			} else if(set.size() == 2) {
				sb.append("Isosceles");
			} else {
				sb.append("Scalene");
			}
		}
		System.out.print(sb);
	}
}