import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String i = br.readLine();
		boolean seven = false;
		for(char c : i.toCharArray()) {
			if(c == '7') {
				seven = true;
				break;
			}
		}
		if(seven) {
			if(Integer.parseInt(i) % 7 == 0) {
				sb.append(3);
			} else {
				sb.append(2);
			}
		} else {
			if(Integer.parseInt(i) % 7 == 0) {
				sb.append(1);
			} else {
				sb.append(0);
			}
		}
        System.out.print(sb);
	}
}