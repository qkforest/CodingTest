import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int[] c = new int[2];
		for(int i = 0; i < N; i++) {
			c[Integer.parseInt(s[i])%2]++;
		}
		if(c[0] <= c[1]) {
			sb.append("Sad");
		} else {
			sb.append("Happy");
		}
        System.out.print(sb);
	}
}