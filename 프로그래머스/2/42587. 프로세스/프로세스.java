import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> q = new ArrayDeque<>();
        
        for(int i = 0; i < priorities.length; i++) {
            q.addLast(new int[]{i, priorities[i]});
        }
        
        Arrays.sort(priorities);
        
        for(int i = 0; i < priorities.length; i++) {
            while(q.peekFirst()[1] != priorities[priorities.length-(i+1)]) {
                q.addLast(q.pollFirst());
            }
            
            if (q.pollFirst()[0] == location) return (i+1);
        }
        
        return -1;
    }
}