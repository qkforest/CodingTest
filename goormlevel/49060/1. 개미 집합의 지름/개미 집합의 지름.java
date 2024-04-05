import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int d = Integer.parseInt(str[1]);
		int[] p = new int[n];
		str = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(str[i]);
		}
		
		Arrays.sort(p);
		
		System.out.println(find(p, n, d));
	}
	static int find(int[] p, int n, int d){
		int start = 0;
		int end = 0;
		int len = 0;
		
		while(start < n && end < n) {
			if(p[end] - p[start] <= d){
				len = Math.max(len, end - start + 1);
				end++;
			} else {
				start++;
			}
		}
		
		return n - len;
	}
}