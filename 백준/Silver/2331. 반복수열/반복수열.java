import java.io.*;
import java.util.*;

class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int A = Integer.parseInt(s[0]);
		int P = Integer.parseInt(s[1]);
		Set<Integer> repeat = new HashSet<>();
		Set<Integer> d = new HashSet<>();
		int pre = A;
		d.add(A);
		while(true) {
			int now = 0;
			for(char c : String.valueOf(pre).toCharArray()) {
				now += (int)Math.pow(c -'0', P);
			}
			if(!d.contains(now) && repeat.contains(now)) {
				break;
			}
			if(!d.contains(now)) {
				d.add(now);
			} else {
				d.remove(now);
				repeat.add(now);
			}
			pre = now;
		}
		System.out.print(d.size());
	}
}