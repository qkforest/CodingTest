import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>(); // Enter 이후 채팅을 입력한 사람들 저장
		int answer = 0; // 곰곰티콘 사용 횟수
		for(int i = 0 ; i < N; i++) {
			String str = br.readLine();
			if(str.equals("ENTER")) {
				answer += set.size(); // 직전 입장에 대한 입력 인원 더하기
				set.clear(); // set 비우기
			} else {
				set.add(str); // 입력 인원 저장
			}
		}
		answer += set.size(); // 직전 입장에 대한 입력 인원 더하기
		System.out.print(answer);
	}
}