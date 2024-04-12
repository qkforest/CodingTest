import java.io.*;
public class Main {
	static int[] roots;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		roots = new int[N+1];
		for(int i = 1; i <= N; i++) {
			roots[i] = i;
		}
		for(int i = 1; i <= N; i++) {
			String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(s[j]) == 1) {
                    union(i, j+1);
                }
            }
		}
		String[] s = br.readLine().split(" ");
		int root = roots[Integer.parseInt(s[0])];
		boolean flag = true;
		for(int i = 1; i < M; i++) {
			if(root != find(Integer.parseInt(s[i]))) {
				flag = false;
                break;
			}
		}
		if (flag) System.out.println("YES");
        else System.out.println("NO");
	}
	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) {
			return;
		}
		if(rootA > rootB) {
			roots[rootA] = rootB;
		} else {
			roots[rootB] = rootA;
		}
	}
	public static int find(int num) {
		if(roots[num] == num) {
			return num;
		}
		return roots[num] = find(roots[num]);
	}
}