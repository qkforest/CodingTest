import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int T = 0; T < testcases; T++) {
			br.readLine();
			String[] str = br.readLine().split(" ");
			StringBuilder answer = new StringBuilder();
			
			for(String s : str) {
				char c = s.charAt(0);
				
				if(answer.length() > 0 && answer.charAt(0) >= c) {
					answer.insert(0, c);
				} else {
					answer.append(c);
				}
			}
			
			sb.append(answer.toString()).append("\n");
		}
		
		System.out.print(sb);
	}
}