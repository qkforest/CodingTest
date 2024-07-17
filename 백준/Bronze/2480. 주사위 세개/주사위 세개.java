import java.io.*;
import java.util.*;
class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] dice = br.readLine().split(" ");
		Set<Integer> set = new HashSet<>();
		int same = 0;
		int max = 0;
		int count = 1;
		for(int i = 0; i < 3; i++) {
			int num = Integer.parseInt(dice[i]);
			if(set.contains(num)) {
				count++;
				same = num;
			} 
			else {
				max = Math.max(max, num);
			}
			set.add(num);
		}
		if(count == 3) {
			System.out.print(10000 + same * 1000);
		} 
		else if(count == 2) {
			System.out.print(1000 + same * 100);
		}
		else {
			System.out.print(max * 100);
		}
	}
}