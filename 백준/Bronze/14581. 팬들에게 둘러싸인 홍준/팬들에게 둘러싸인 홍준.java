import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = ":fan:";
		sb.append(s.repeat(3)).append("\n").append(s).append(":").append(br.readLine()).append(":").append(s).append("\n").append(s.repeat(3));
        System.out.print(sb);
	}
}