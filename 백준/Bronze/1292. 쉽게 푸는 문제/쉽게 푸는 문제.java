import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int start = Integer.parseInt(s[0]);
		int end = Integer.parseInt(s[1]);
		int idx = 1;
		int num = 1;
		long answer = 0;
		while(idx <= end) {
			if(idx >= start && idx <= end) {
				answer += num;
			}
			if(idx == num *(num + 1) / 2) {
				num++;
			}
			idx++;
		}
		System.out.println(answer);
	}
}