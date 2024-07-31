import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Double> grades = new HashMap<>();
		grades.put("A+", 4.5);
		grades.put("A0", 4.0);
		grades.put("B+", 3.5);
		grades.put("B0", 3.0);
		grades.put("C+", 2.5);
		grades.put("C0", 2.0);
		grades.put("D+", 1.5);
		grades.put("D0", 1.0);
		grades.put("F", 0.0);
		double average = 0;
		double count = 0;
		for(int i = 0; i < 20; i++) {
			String[] s = br.readLine().split(" ");
			if(s[2].equals("P")) {
				continue;
			}
			double score = Double.parseDouble(s[1]);
			count += score;
			average += score * grades.get(s[2]);
		}
		System.out.print(String.format("%.6f", average / count));
	}
}