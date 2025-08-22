import java.util.*;

class Solution {
    private static int len;
    private static class Node {       
        public final int value;
        public final int x;
        public final int y;
        
        public Node left;
        public Node right;
        
        private Node(int value, int x, int y) {
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
    
    private void preOrder(Node node, List<Integer> visit) {
        visit.add(node.value);
        if(node.left != null) {
            preOrder(node.left, visit);
        }
        if(node.right != null) {
            preOrder(node.right, visit);
        }
    }
    
    private void postOrder(Node node, List<Integer> visit) {
        if(node.left != null) {
            postOrder(node.left, visit);
        }
        if(node.right != null) {
            postOrder(node.right, visit);
        }
        visit.add(node.value);
    }
    
    
    public int[][] solution(int[][] nodeinfo) {
        len = nodeinfo.length;
        Node[] nodes = new Node[len];
        for(int i = 0; i < len; i++) {
            nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        Arrays.sort(nodes, (a, b) -> b.y - a.y);
        Node root = constructTree(nodes);
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        preOrder(root, preOrder);
        postOrder(root, postOrder);
        return new int[][] {preOrder.stream().mapToInt(Integer::intValue).toArray(),
            postOrder.stream().mapToInt(Integer::intValue).toArray()};
    }
}