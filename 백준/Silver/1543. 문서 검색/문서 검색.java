import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder doc = new StringBuilder(br.readLine());
		String search = br.readLine();
		
		int start = 0;
		int end = search.length();
		int count = 0;
		
		while(start < doc.length() && end <= doc.length()) {
			if(doc.substring(start, end).equals(search)) {
				count++;
				start = end;
				end = start + search.length();
			} else {
				start++;
				end++;
			}
		}
		
		System.out.print(count);
	}
}