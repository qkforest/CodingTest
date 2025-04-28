import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		if(br.readLine().equals("0")) {
			sb.append("YONSEI");
		} else {
			sb.append("Leading the Way to the Future");
		}
        System.out.print(sb);
	}
}