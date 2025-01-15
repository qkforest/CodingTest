import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int max = -1;
		int[] pos = new int[2];
		for(int i = 0; i< 9; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 0; j < 9; j++) {
				int n = Integer.parseInt(s[j]);
				if(max < n) {
					max = n;
					pos[0] = i+1;
					pos[1] = j+1;
				}
			}
		}
		sb.append(max).append("\n").append(pos[0]).append(" ").append(pos[1]);
		System.out.print(sb);
	}
}