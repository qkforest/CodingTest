import java.io.*;
class Main {
	public static StringBuilder sb;
	public static long cnt;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		 cnt = 0;
		hanoi(N, 1, 2, 3);
		System.out.print(cnt+ "\n" +sb);
	}
	public static void hanoi(int n, int start, int mid, int des) {
		cnt++;
		if(n == 1) {
			sb.append(start).append(" ").append(des).append("\n");
			return;
		}
		hanoi(n-1, start, des, mid);
		sb.append(start).append(" ").append(des).append("\n");
		hanoi(n-1, mid, start, des);
	}
}