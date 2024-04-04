import java.util.*;
import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		for(int i = 0; i < len; i++) {
			String[] str = br.readLine().split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			int n = Integer.parseInt(str[2]);
			int total = Math.abs(x) + Math.abs(y);
			if(Math.abs(x) + Math.abs(y) > n)
				System.out.println("NO");
			else if((total % 2 == 0 &&  n % 2 == 0) || (total % 2 == 1 &&  n % 2 == 1))
				System.out.println("YES");
			else {
				System.out.println("NO");
			}
		}
	}
}