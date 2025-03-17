import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		while(!(s=br.readLine()).equals("#")) {
			String[] arr = s.split(" ");
			int count = 0;
			char n = arr[0].charAt(0);
			sb.append(n).append(" ");
			for(int i = 1; i < arr.length; i++) {
				for(char c : arr[i].toCharArray()) {
					if(Character.toLowerCase(c) == n) {
						count++;
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.print(sb);
	}
}