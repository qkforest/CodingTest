import java.util.*;
import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int Min = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
		int Man = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
		sb.append(Math.max(Min, Man));
		System.out.print(sb);
	}
}