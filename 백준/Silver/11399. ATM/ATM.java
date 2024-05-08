import java.io.*;
import java.util.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] times = Arrays.stream(br.readLine().split(" "))
							.mapToInt(Integer::parseInt).toArray();
		Arrays.sort(times);
		int answer = 0;
		int now = 0;
		for(int t : times) {
			now += t;
			answer += now;
		}
		System.out.println(answer);
	}
}