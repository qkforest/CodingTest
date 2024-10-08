import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
        int A = Integer.parseInt(s[0]);
        int B = Integer.parseInt(s[1]);
        StringBuilder sb = new StringBuilder();
        sb.append(A+B).append("\n");
        sb.append(A-B).append("\n");
        sb.append(A*B).append("\n");
        sb.append(A/B).append("\n");
        sb.append(A%B).append("\n");
        System.out.print(sb);
	}
}