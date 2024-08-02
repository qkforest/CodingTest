import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 상자의 개수
		String[] s = br.readLine().split(" ");
		int[][] box = new int[n][2]; 
		int answer = 1;
		for(int i = 0; i < n; i++) {
			box[i][0] = Integer.parseInt(s[i]);
			box[i][1] = 1;
			for(int j = 0; j < i; j++) {
				if(box[j][0] < box[i][0] && box[j][1] + 1 > box[i][1]) {
					 box[i][1] = box[j][1] + 1;
				}
			}
			answer = Math.max(answer, box[i][1]);
		}
		System.out.print(answer);
	}
}