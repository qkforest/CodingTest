import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		String[] times = br.readLine().split(" ");
		int S = toIntTime(times[0]);
		int E = toIntTime(times[1]);
		int Q = toIntTime(times[2]);
		Set<String> set = new HashSet<>();
		String str = "";
		while((str = br.readLine()) != null) {
			String[] record = str.split(" ");
			int time = toIntTime(record[0]);
			if(time <= S) {
				set.add(record[1]);
			}
			else if(time >= E && time <= Q) {
				if(set.contains(record[1])) {
					answer++;
					set.remove(record[1]);
				}
			}
		}
		System.out.print(answer);
	}
	public static int toIntTime(String s) {
		int time = 0;
		String[] HM = s.split(":");
		time = Integer.parseInt(HM[0]) * 60 + Integer.parseInt(HM[1]);
		return time;
	}
}