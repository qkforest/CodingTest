import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] lines = new int[N][2];
		for(int i = 0; i < N; i++) {
			lines[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		Arrays.sort(lines, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o2[1] - o1[1]);
		int answer = lines[0][1] - lines[0][0];
		int pre = lines[0][0];
		for(int i = 1; i < N; i++) {
			if(lines[i][0] >= pre) {
				continue;
			} else {
				if(lines[i][1] > pre) {
					answer += pre - lines[i][0]; 
				} else {
					answer += lines[i][1] - lines[i][0]; 
				}
				pre = lines[i][0];
			}
		}
		System.out.print(answer);
	}
}