import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			sum += Integer.parseInt(br.readLine());
		}
		sb.append(sum);
        System.out.print(sb);
	}
}