import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		sb.append((int)Math.floor((Integer.parseInt(s[0])+1)*(Integer.parseInt(s[1])+1)/(Integer.parseInt(s[2])+1)-1));
        System.out.print(sb);
	}
}