import java.io.*;
import java.util.*;
class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<Word> words = new TreeSet<>();
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			words.add(new Word(str, str.length()));
		}
		StringBuilder sb = new StringBuilder();
		for(Word word : words) {
			sb.append(word.word).append("\n");
		}
		System.out.print(sb);
	}
	static class Word implements Comparable<Word> {
		String word;
		int length;
		
		public Word(String word, int length) {
			this.word = word;
			this.length = length;
		}
		@Override
		public int compareTo(Word other) {
			if(this.length == other.length) {
				return this.word.compareTo(other.word);
			}
			return this.length - other.length;
		}
	}
}