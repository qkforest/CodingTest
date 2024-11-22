import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		int idx = 1;
		while(!(s = br.readLine()).equals("0 0 0")) {
			String[] arr = s.split(" ");
			int L = Integer.parseInt(arr[0]);
			int P = Integer.parseInt(arr[1]);
			int V = Integer.parseInt(arr[2]);
			int answer = V / P * L + Math.min(V % P, L);
			sb.append("Case ").append(idx).append(": ").append(answer).append("\n");
			idx++;
		}
		System.out.print(sb);
	}
}