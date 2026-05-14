import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        
        for (int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        
        Arrays.sort(costs, (a,b) -> a[2] - b[2]);
        
        for (int[] cost : costs) {
            if(find(parent, cost[0]) == find(parent, cost[1])) continue;
            answer += cost[2];
            union(parent, cost[0], cost[1]);
        }
        
        return answer;
    }
    
    private int find(int[] parent, int idx) {
        if (parent[idx] == idx) return idx;
        
        return parent[idx] = find(parent, parent[idx]);
    }
    
    private void union(int[] parent, int a, int b) {
        int p1 = find(parent, a);
        int p2 = find(parent, b);
        
        parent[p1] = p2;
    }
}