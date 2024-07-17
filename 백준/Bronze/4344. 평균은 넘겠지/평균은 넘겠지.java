import java.io.*;

class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < C; i++) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int[] scores = new int[N];
			double average = 0;
			int count = 0;
			for(int j = 0; j < N; j++) {
				scores[j] = Integer.parseInt(s[j+1]);
				average += scores[j];
			}
			average /= (double)N;
			for(int j = 0; j < N; j++) {
				if(scores[j] > average) {
					count++;
				}
			}
			double answer = count / (double)N * 100;
			sb.append(String.format("%.3f", answer)).append("%\n");
		}
		System.out.println(sb);
	}
}