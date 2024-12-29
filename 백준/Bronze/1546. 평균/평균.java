import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[] scores = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
		Arrays.sort(scores);
		double max = scores[N-1];
		double mean = 0;
		for(int i = 0; i < N; i++) {
			mean += scores[i] / max * 100; 
		}
		System.out.print(mean/(double)N);
	}
}