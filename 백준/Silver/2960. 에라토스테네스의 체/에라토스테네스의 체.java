import java.io.*;
import java.util.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		boolean[] visited = new boolean[N+1];
		int answer = 0;
		
		for(int i = 2; i <= N; i++) {
			if(!visited[i] && isPrime(i)) {
				int m = 1;
				while(K > 0 && m * i <= N) {
					if(!visited[m*i]) {
						visited[m*i] = true;
						K--;
						answer = m*i;
					}
					m++;
				}
			}
			if(K == 0) {
				break;
			}
		}
		
		System.out.print(answer);
	}
	public static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
}