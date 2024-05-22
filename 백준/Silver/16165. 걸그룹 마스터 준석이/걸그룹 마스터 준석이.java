import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		Map<String, String> mem = new HashMap<>();
		Map<String, List<String>> team = new HashMap<>();
		for(int i = 0; i < N; i++) {
			String teamname = br.readLine();
			List<String> temp = new ArrayList<>();;
			int num = Integer.parseInt(br.readLine());
			for(int j = 0; j < num; j++) {
				String name = br.readLine();
				temp.add(name);
				mem.put(name, teamname);
			}
			team.put(teamname, temp);
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			String op = br.readLine();
			if(op.equals("0")) {
				List<String> temp = team.get(str);
				Collections.sort(temp);
				for(String n : temp) {
					sb.append(n + "\n");
				}
			} else {
				sb.append(mem.get(str) + "\n");
			}
		}
		System.out.print(sb);
	}
}
