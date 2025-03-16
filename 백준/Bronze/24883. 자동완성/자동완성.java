import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine().toLowerCase();
		if(s.equals("n")) {
			sb.append("Naver D2");
		} else {
			sb.append("Naver Whale");
		}
		System.out.print(sb);
	}
}