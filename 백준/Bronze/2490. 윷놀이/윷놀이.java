import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] results = {'E', 'A', 'B', 'C', 'D'};
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 3; i++) {
			String[] str = br.readLine().split(" ");
			int count = 0;
			for(String s : str) {
				if(s.equals("0")) {
					count++;
				}
			}
			sb.append(results[count]).append("\n");
		}
		System.out.print(sb);
	}
}