import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;
		while((line=br.readLine()) != null) {
			String[] arr = line.split(" ");
			long N = Long.parseLong(arr[0])+1;
			long S = Long.parseLong(arr[1]);
			sb.append(S/N).append("\n");
		}
        System.out.print(sb);
	}
}