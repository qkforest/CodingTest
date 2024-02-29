import java.util.*;
class Solution {
    static int idx;
    static int[][] answer;
    public int[][] solution(int[][] nodeinfo) {
        int num = nodeinfo.length;
        answer = new int[2][num];
        Node[] nodes = new Node[num];
        for(int i = 0; i < num; i++)
            nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1], null, null);
        Arrays.sort(nodes, (a, b) -> a.y == b.y ? a.x - b.x : b.y - a.y);
        Node parent = nodes[0];
        for(int i = 1; i < num; i++)
            constructTree(parent, nodes[i]);
        idx = 0;
        preOrder(parent);
        idx = 0;
        postOrder(parent); 
        return answer;
    }
    class Node {
        int value;
        int x;
        int y;
        Node left;
        Node right;
        
        public Node(int value, int x, int y, Node left, Node right){
            this.value = value;
            this.x = x;
            this.y = y;
            this.left = left;
            this.right = right;
        }
    }
    public void constructTree(Node parent, Node child){
        if(parent.x >= child.x){
            if(parent.left == null)
                parent.left = child;
            else
                constructTree(parent.left, child);
        } else {
            if(parent.right == null)
                parent.right = child;
            else
                constructTree(parent.right, child);
        }
    }
    public void preOrder(Node root){
       if(root != null){
            answer[0][idx++] = root.value;
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public void postOrder(Node root){
       if(root != null){
           postOrder(root.left);
           postOrder(root.right);
           answer[1][idx++] = root.value;
        }
    }
}