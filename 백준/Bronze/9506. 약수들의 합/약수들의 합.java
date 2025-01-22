import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		while(!(s = br.readLine()).equals("-1")) {
			int n = Integer.parseInt(s);
			StringBuilder temp = new StringBuilder();
			temp.append(n).append(" = ").append("1");
			int sum = 1;
			for(int i = 2; i < n; i++) {
				if(n % i == 0) {
					temp.append(" + ").append(i);
					sum += i;
				}
			}
			if(sum == n) {
				sb.append(temp);
			} else {
				sb.append(n).append(" is NOT perfect.");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}