import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long X = Long.parseLong(br.readLine());
		int N = Integer.parseInt(br.readLine());
		long sum = 0;
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			sum += Integer.parseInt(s[0]) * Integer.parseInt(s[1]);
		}
		String answer = "Yes";
		if(X != sum) {
			answer = "No";
		}
		System.out.print(answer);
	}
}