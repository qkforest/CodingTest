import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			boolean[] rooms = new boolean[n+1];
			int count = 0;
			for(int j = 1; j <= n; j++) {
				int mul = 1;
				while(j * mul <= n) {
					if(!rooms[j*mul]) {
						count++;
						rooms[j*mul] = true;
					}
					else {
						count--;
						rooms[j*mul] =false;
					}
					mul++;
				}
			}
			sb.append(count).append("\n");
		}
		System.out.print(sb);
	}
}