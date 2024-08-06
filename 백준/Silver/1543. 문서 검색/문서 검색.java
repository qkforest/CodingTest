import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String doc = br.readLine(); // 문서
		String search = br.readLine(); // 검색 단어
		
		int start = 0; // 서브스트링의 시작 인덱스
		int end = search.length(); // 서브스트링의 끝 인덱스
		int count = 0; // 중복 없이 등장하는 단어 개수
		
		while(start < doc.length() && end <= doc.length()) {
			int next = start + 1;
			if(doc.substring(start, end).equals(search)) {
				count++;
				next = end;
			}
			int idx = doc.substring(next).indexOf(search.charAt(0));
			if(idx == -1) {
				break;
			}
			start = next + idx;
			end = start + search.length();
		}
		
		System.out.print(count);
	}
}