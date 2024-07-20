import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new TreeMap<>(); // 이름 사전 순 저장
		
		for(int i = 0; i < N; i++) {
			String[] s = br.readLine().split("\\.");
			map.merge(s[1], 1, Integer::sum);
		}
		
		StringBuilder sb = new StringBuilder();
		
		// 남은 인원 출력
		for(String name : map.keySet()) {
			sb.append(name).append(" ").append(map.get(name)).append("\n");
		}
		
		System.out.print(sb);
	}
}
