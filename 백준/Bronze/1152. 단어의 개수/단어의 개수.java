import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String[] s = br.readLine().split(" ");
		int count = s.length;
		if(count > 0) {
			if(s[count-1].equals("")) {
				count--;
			}
			if(s[0].equals("")) {
				count--;
			}
		}
		System.out.print(count);
	}
}