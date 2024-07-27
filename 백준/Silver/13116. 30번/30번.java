import java.io.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < testcases; t++) {
			String[] s = br.readLine().split(" ");
			int A = Integer.parseInt(s[0]);
			int B = Integer.parseInt(s[1]);
			sb.append(find(A, B) * 10).append("\n");
		}
		System.out.print(sb);
	}
	public static int find (int A, int B) {
		int levelA = (int)(Math.log(A)/ Math.log(2));
		int levelB = (int)(Math.log(B)/ Math.log(2));
		if(levelA > levelB) {
			while(levelA != levelB) {
				A /= 2;
				levelA--;
			}
		} else if(levelA < levelB) {
			while(levelA != levelB) {
				B /= 2;
				levelB--;
			}
		}
		while(A != B) {
			A /= 2;
			B /= 2;
		}
		return A;
	}
}