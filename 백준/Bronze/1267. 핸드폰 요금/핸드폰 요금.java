import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int Y = 0;
		int M = 0;
		int[] time = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for(int i = 0; i < N; i++) {
			Y += 10;
			Y += (time[i] / 30) * 10;
			M += 15;
			M += (time[i] / 60) * 15;
		}
		if(Y < M) {
			System.out.print("Y " + Y);
		} else if(Y > M) {
			System.out.print("M " + M);
		} else {
			System.out.print("Y M " + M);
		}
	}
}