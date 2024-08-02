import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[][] sequence = new int[N][2];
		for(int i = 0; i < N; i++) {
			sequence[i][0] = Integer.parseInt(str[i]);
			sequence[i][1] = 1;
		}
		int answer = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(sequence[j][0] > sequence[i][0] && sequence[j][1] + 1 > sequence[i][1]) {
					sequence[i][1] = sequence[j][1] + 1;
				}
			}
			answer = Math.max(answer, sequence[i][1]);
		}
 		System.out.print(answer);
	}
}