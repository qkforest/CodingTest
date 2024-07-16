import java.io.*;
class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		int[] fac = new int[n+1];
		fac[0] = 1;
		for(int i = 1; i <= n; i++) {
			fac[i] = fac[i-1] * i;
		}
		int answer = fac[n] / (fac[n-k] * fac[k]);
		System.out.print(answer);
	}
}