import java.util.HashMap;
class Solution {
    static Node root = new Node();
    public int solution(String[] words) {
        for(String word : words) {
            insert(word);
        }
        return search(root, 0);
    }
    static class Node {
        HashMap<Character, Node> childNodes = new HashMap<>();
        int childCount = 0;
        
        Node put(char c) {
            childCount++;
            if(!childNodes.containsKey(c)) {
                childNodes.put(c, new Node());
            }
            return childNodes.get(c);
        }
    }
    public void insert(String word) {
        Node curNode = root;
        for(int i = 0; i < word.length(); i++) {
            Node newRoot = curNode.put(word.charAt(i));
            curNode = newRoot;
        }
        curNode.put('*');
    }
    public int search(Node root, int cnt) {
        if(root.childCount == 1) {
            return cnt;
        }
        int count = 0;
        for(char key : root.childNodes.keySet()){
            if(key == '*') {
                count += cnt;
            } else {
                count += search(root.childNodes.get(key), cnt + 1);
            }
        }
        return count;
    }
}