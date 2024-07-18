import java.io.*;

class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		double len = s.length();
		double num = Double.parseDouble(s);
		double answer = 0;
		for(int i = 1; i <= len - 1; i++) {
			answer += i *((Math.pow(10, i) - Math.pow(10, i-1)));
		}
		answer += len * (num + 1 - (Math.pow(10, len-1)));
		System.out.print((int)answer);
	}
}