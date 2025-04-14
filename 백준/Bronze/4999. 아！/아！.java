import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] j = new int[2];
		int[] d = new int[2];
		String s = br.readLine();
		for(char c : s.toCharArray()) {
			if(c - 'a' == 0) {
				j[0]++;
			} else {
				j[1]++;
			}
		}
		s = br.readLine();
		for(char c : s.toCharArray()) {
			if(c - 'a' == 0) {
				d[0]++;
			} else {
				d[1]++;
			}
		}
		if(j[0] >= d[0] && j[1] >= d[1]) {
			sb.append("go");
		} else {
			sb.append("no");
		}
        System.out.print(sb);
	}
}