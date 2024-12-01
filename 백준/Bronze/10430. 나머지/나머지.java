import java.io.*;
class Main {
	public static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int A = Integer.parseInt(s[0]);
		int B = Integer.parseInt(s[1]);
		int C = Integer.parseInt(s[2]);
		StringBuilder sb = new StringBuilder();
		sb.append((A+B)%C).append("\n").append(((A%C)+(B%C))%C).append("\n").append(((A%C)*(B%C))%C).append("\n").append((A*B)%C).append("\n");
		System.out.print(sb);
	}
}