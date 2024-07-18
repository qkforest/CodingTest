import java.io.*;

class Main{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		int sum = 0;
		int idx = 1;
		while(sum + idx < X) {
			sum += idx;
			idx++;
		}
		sum += 1;
		
		if(idx % 2 == 0) {
			int den = 1;
			int num = idx;
			for(int i = sum+1; i <= X; i++) {
				den++;
				num--;
			}
			System.out.println(den + "/" + num);
		}
		else {
			int den = idx;
			int num = 1;
			for(int i = sum+1; i <= X; i++) {
				den--;
				num++;
			}
			System.out.println(den + "/" + num);
		}
	}
}