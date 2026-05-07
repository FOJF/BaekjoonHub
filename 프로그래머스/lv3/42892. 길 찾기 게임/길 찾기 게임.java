import java.util.*;

class Solution {
    public List<Integer>[] solution(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        Arrays.sort(nodes);
        
        Node.rootNode = nodes[0];
        
        for (int i = 1; i < nodes.length; i++) {
            Node.addEdge(nodes[i]);
        }
        
        
        
        List<Integer>[] answer = new ArrayList[2];
        answer[0] = Node.rootNode.preorder();
        answer[1] = new ArrayList<>();
        Node.postorder(Node.rootNode, answer[1]);
        return answer;
    }
}

class Node implements Comparable {
    static Node rootNode = null;
    
    int idx, x, y;
    Node left, right;
    
    public Node(int idx, int x, int y) {
        this.idx = idx;
        this.x = x;
        this.y = y;
    }
    
    public static void addEdge(Node targetNode) {
        Node nowNode = rootNode;
        
        boolean isLeft = nowNode.x > targetNode.x;
        
        while(true) {
            if (nowNode.x > targetNode.x) { // 왼쪽
                if (nowNode.left == null) {
                    nowNode.left = targetNode;
                    return;
                } else {
                    nowNode = nowNode.left;
                }
            } else { // 오른쪽
                if (nowNode.right == null) {
                    nowNode.right = targetNode;
                    return;
                } else {
                    nowNode = nowNode.right;
                }
            }
        }
    }
    
    public List<Integer> preorder() {
        List<Integer> result = new ArrayList<>();
        
        Stack<Node> stack = new Stack<>();
        stack.push(rootNode);
        
        while(!stack.isEmpty()) {
            Node now = stack.pop();
            result.add(now.idx);
            if (now.right != null) stack.push(now.right);
            if (now.left != null) stack.push(now.left);
        }
        return result;
    }
    
    public static void postorder(Node start, List<Integer> result) {
        if (start.left != null) postorder(start.left, result);
        if (start.right != null) postorder(start.right, result);
        result.add(start.idx);
    }
    
    public int compareTo(Object another) {
        Node a = (Node)another;
        if (this.y == a.y) return this.x - a.x;
        return a.y - this.y;
    }
}