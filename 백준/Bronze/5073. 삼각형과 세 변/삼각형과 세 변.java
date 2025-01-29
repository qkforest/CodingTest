import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		while(!(s=br.readLine()).equals("0 0 0")) {
			int[] len = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
			Arrays.sort(len);
			if(len[2] >= len[0]+len[1]) {
				sb.append("Invalid");
			} else {
				if(len[0] == len[2]) {
					sb.append("Equilateral");
				} else if(len[0] == len[1] || len[2] == len[1]) {
					sb.append("Isosceles");
				} else {
					sb.append("Scalene");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}