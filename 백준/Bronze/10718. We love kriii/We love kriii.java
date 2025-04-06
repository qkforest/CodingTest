import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = "강한친구 대한육군";
		sb.append(s).append("\n").append(s);
        System.out.print(sb);
	}
}