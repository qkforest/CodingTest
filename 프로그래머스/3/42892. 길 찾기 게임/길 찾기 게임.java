import java.util.*;
class Solution {
    private static int len, idx;
    private static class Node {
        public final int value;
        public final int x;
        public final int y;
        
        public Node left;
        public Node right;
        
        public Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }
    
    private Node constructTree(Node[] nodes) {
        Node root = nodes[0];
        
        for(int i = 1; i < len; i++) {
            insert(root, nodes[i]);
        }
        
        return root;
    }
    private void insert(Node root, Node node) {
        if(node.x < root.x) {
            if(root.left == null) {
                root.left = node;
            } else {
                insert(root.left, node);
            }
        } else {
            if(root.right == null) {
                root.right = node;
            } else {
                insert(root.right, node);
            }
        }
    }
    
    private void preOrder(Node root, int[][] answer) {
        answer[0][idx++] = root.value;
        if(root.left != null) {
            preOrder(root.left, answer);
        }
        if(root.right != null) {
            preOrder(root.right, answer);
        }
    }
    
    private void postOrder(Node root, int[][] answer) {
        if(root.left != null) {
            postOrder(root.left, answer);
        }
        if(root.right != null) {
            postOrder(root.right, answer);
        }
        answer[1][idx++] = root.value;
    }
    
    public int[][] solution(int[][] nodeinfo) {
        len = nodeinfo.length;
        idx = 0;
        int[][] answer = new int[2][len];
        Node[] nodes = new Node[len];
        
        for(int i = 0; i < len; i++) {
            nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        Arrays.sort(nodes, (a, b) -> b.y - a.y);
        Node root = constructTree(nodes);
        
        preOrder(root, answer);
        idx = 0;
        postOrder(root, answer);
        
        return answer;
    }
}