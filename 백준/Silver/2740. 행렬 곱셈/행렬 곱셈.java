import java.io.*;

class Main{
	public static int N, M, K;
	public static long[][] matrixMultiply(int[][] matrixA, int[][] matrixB) {
		long[][] answer = new long[N][K];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < K; j++) {
				for(int k = 0 ; k < M; k++) {
					answer[i][j] += matrixA[i][k] * matrixB[k][j];
				}
			}
		}
		
		return answer;
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		int[][] matrixA = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				matrixA[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		str = br.readLine().split(" ");
		K = Integer.parseInt(str[1]);
		int[][] matrixB = new int[M][K];
		
		for(int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			for(int j = 0; j < K; j++) {
				matrixB[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		long[][] answer = matrixMultiply(matrixA, matrixB);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < K; j++) {
				sb.append(answer[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}