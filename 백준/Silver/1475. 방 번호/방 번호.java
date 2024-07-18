import java.io.*;

class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] counts = new int[9];
		String str = br.readLine();
		int max = 0;
		for(char c : str.toCharArray()) {
			int num = c - '0';
			if(num == 9) {
				num = 6;
			}
			counts[num]++;
			int count = counts[num];
			if(num == 6) {
				if(count % 2 == 0) {
					count = counts[num] / 2;
				}
				else {
					count = counts[num] / 2 + 1;
				}
			}
			max = Math.max(max, count);
		}
		System.out.print(max);
	}
}