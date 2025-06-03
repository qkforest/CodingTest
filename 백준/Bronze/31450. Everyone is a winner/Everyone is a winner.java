import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		if(Integer.parseInt(s[0]) % Integer.parseInt(s[1]) == 0) {
			sb.append("Yes");
		} else {
			sb.append("No");
		}
        System.out.print(sb);
	}
}