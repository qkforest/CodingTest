import java.io.*;

class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int x = Integer.parseInt(s[0]);
		int y = Integer.parseInt(s[1]);
		String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for(int i = 1; i < x; i++) {
			y += months[i];
		}
		System.out.println(week[y%7]);
	}
}