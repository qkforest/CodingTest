import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] students = new int[30];
		for(int i = 0; i < 28; i++) {
			students[Integer.parseInt(br.readLine())-1]++;
		}
		int count = 0;
		int idx = 0;
		while(count < 2 && idx < 30) {
			if(students[idx] == 0) {
				sb.append(idx+1).append("\n");
				count++;
			}
			idx++;
		}
		System.out.print(sb);
	}
}