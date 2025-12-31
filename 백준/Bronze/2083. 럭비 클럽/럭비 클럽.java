import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		StringBuilder sb = new StringBuilder();
		while(!(s=br.readLine()).equals("# 0 0")) {
			String[] arr = s.split(" ");
			String club = "Junior";
			sb.append(arr[0]).append(" ");
			if(Integer.parseInt(arr[1]) > 17 || Integer.parseInt(arr[2]) >= 80) {
				club = "Senior";
			}
			sb.append(club).append("\n");
		}
		System.out.print(sb);
	}
}