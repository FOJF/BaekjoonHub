import java.util.*;

class Solution {
    final static int WOLF = 1;
    final static int SHEEP = 0;
    
    public int solution(int[] info, int[][] edges) {
        
        boolean[] isVisited = new boolean[info.length];

        Node[] nodes = new Node[info.length];
        Arrays.setAll(nodes, i -> new Node(i, info[i]));
        
        for(int[] edge : edges) {
            Node parent = nodes[edge[0]];
            Node child = nodes[edge[1]];
            Node.linkNodes(parent, child);
        }
        
        Set<Integer> nexts = new HashSet<>();
        int[] sheepWolfCnt={0,0};
        nexts.add(0);
        
        dfs(sheepWolfCnt, nodes, nexts);
        
        return answer;
    }
    
    static int answer=1;
    
    public void dfs(int[] sheepWolfCnt, Node[] nodes, Set<Integer> nexts) {
        answer = Math.max(answer, sheepWolfCnt[SHEEP]);
        for (int nextId : nexts) {
            Node next = nodes[nextId];
            
            int[] expectedSheepWolfCnt = Arrays.copyOf(sheepWolfCnt, sheepWolfCnt.length);
            expectedSheepWolfCnt[next.info]++;
            
            if (expectedSheepWolfCnt[SHEEP] <= expectedSheepWolfCnt[WOLF]) continue;
            
            Set<Integer> newNexts = new HashSet<>(nexts);
            newNexts.remove(nextId);
            
            if (next.left != null) newNexts.add(next.left.id);
            if (next.right != null) newNexts.add(next.right.id);
            
            dfs(expectedSheepWolfCnt, nodes, newNexts);
        }        
    }
}

class Node {
    static Node root;

    int id;
    int info;
    Node left, right;

    public Node(int id, int info) {
        this.id = id;
        this.info = info;
    }
    
    static void linkNodes(Node parent, Node child) {
        if (parent.left == null) parent.left = child;
        else if (parent.right == null) parent.right = child;
    }
}