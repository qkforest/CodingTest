import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		int answer = t / 5;
		if(t % 5 != 0) {
			answer++;
		}
		sb.append(answer);
        System.out.print(sb);
	}
}