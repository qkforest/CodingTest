import java.util.*;
import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		while(!(s = br.readLine()).equals("0 0")) {
			sb.append(Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).sum()).append("\n");
		}
		System.out.print(sb);
	}
}