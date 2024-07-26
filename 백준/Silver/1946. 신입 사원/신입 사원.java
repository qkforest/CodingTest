import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < testcases; t++) {
			int N = Integer.parseInt(br.readLine());
			Score[] scores = new Score[N];
			for(int i = 0; i < N; i++) {
				String[] str = br.readLine().split(" "); 
				scores[i] = new Score(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
			}
			Arrays.sort(scores);
			int answer = 1;
			int min = scores[0].interview;
			for(int i = 1; i < N; i++) {
				if(scores[i].interview < min) {
					min = scores[i].interview;
					answer++;
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.print(sb);
	}
	static class Score implements Comparable<Score>{
		int resume;
		int interview;
		
		public Score(int resume, int interview) {
			this.resume = resume;
			this.interview = interview;
		}
		
		@Override
		public int compareTo(Score other) {
			return this.resume - other.resume;
		}
	}
}