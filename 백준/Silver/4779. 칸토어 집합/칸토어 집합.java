import java.io.*;

class Main{
	public static StringBuilder sb;
	public static void cantorSet(int level, int start, int end) {
		if(level == 0) {
			return;
		}
		int len = (end - start) / 3;
		sb.replace(start + len, end - len, " ".repeat(len));
		cantorSet(level-1, start, start+len);
		cantorSet(level-1, end-len, end);
	}
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		StringBuilder answer = new StringBuilder();
		while((s = br.readLine()) != null) {
			int N = Integer.parseInt(s);
			int len = (int)Math.pow(3, N);
			sb = new StringBuilder("-".repeat(len));
			cantorSet(N, 0, len);
			answer.append(sb.toString()).append("\n");	
		}
		System.out.print(answer);
	}
}