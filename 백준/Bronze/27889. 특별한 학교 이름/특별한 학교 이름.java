import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		if(s.charAt(0) == 'N') {
			sb.append("North London Collegiate School");
		} else if(s.charAt(0) == 'B') {
			sb.append("Branksome Hall Asia");
		} else if(s.charAt(0) == 'K') {
			sb.append("Korea International School");
		} else {
			sb.append("St. Johnsbury Academy");
		}
        System.out.print(sb);
	}
}