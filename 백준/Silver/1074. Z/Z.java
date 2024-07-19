import java.io.*;

class Main{
	public static int answer;
	public static void find(int size, int r, int c) {
		
		// 재귀 종료
		if(size == 1) {
			return;
		}
		// r,c가 1사분면에 속하는 경우
		if(r < size/2 && c < size/2) {
			find(size/2, r, c);
		}
		// r,c가 2사분면에 속하는 경우
		else if(r < size/2 && c >= size/2) {
			answer += size * size / 4; // 1사분면 방문 완료해야 함
			find(size/2, r, c - size/2);
		}
		// r,c가 3사분면에 속하는 경우
		else if(r >= size/2 && c < size/2) {
			answer += (size * size / 4) * 2; // 1, 2사분면 방문 완료해야 함
			find(size/2, r - size/2, c);
		}
		// r,c가 4사분면에 속하는 경우
		else {
			answer += (size * size / 4) * 3; // 1, 2, 3사분면 방문 완료해야 함
			find(size/2, r - size/2, c - size/2);
		}
	}
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int r = Integer.parseInt(s[1]);
		int c = Integer.parseInt(s[2]);
		answer = 0;
		find((int)Math.pow(2, N), r, c);
		System.out.print(answer);
	}
}