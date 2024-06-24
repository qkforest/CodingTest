class Solution {
    public String robotWithString(String s) {
        int[] count = new int[26];
        StringBuilder answer = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        char minChar = 'a';
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            stack.push(c);
            while (minChar < 'z' && count[minChar - 'a'] == 0) {
                minChar++;
            }
            while (!stack.isEmpty() && stack.peek() <= minChar) {
                answer.append(stack.pop());
            }
        }
        return answer.toString();
    }
}