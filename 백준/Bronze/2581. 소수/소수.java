import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		long sum = 0;
		int min = Integer.MAX_VALUE;
		for(int i = M; i <= N; i++) {
			boolean decimal = true;
            if(i == 1) {
				continue;
			}
			for(int j = 2; j <= Math.sqrt(i); j++) {
				if(i % j == 0) {
					decimal = false;
					break;
				}
			}
			if(decimal) {
				sum += i;
				min = Math.min(min, i);
			}
		}
		if(sum == 0) {
			sb.append(-1);
		} else {
			sb.append(sum).append("\n").append(min);
		}
		System.out.print(sb) ;
	}
}