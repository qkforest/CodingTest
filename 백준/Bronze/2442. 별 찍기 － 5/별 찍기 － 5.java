import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= (2 * N - 1)  ; i+=2) {
            for(int j = 0; j < (2*N-1-i) / 2; j++){
            	sb.append(" ");
            }
            for(int j = 0; j < i; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb.deleteCharAt(sb.length()-1));
	}
}