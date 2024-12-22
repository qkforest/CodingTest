import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		while((s = br.readLine()) != null) {
			String[] str = s.split(" ");
			sb.append(Integer.parseInt(str[0])+Integer.parseInt(str[1])).append("\n");
		}
		System.out.print(sb);
	}
}