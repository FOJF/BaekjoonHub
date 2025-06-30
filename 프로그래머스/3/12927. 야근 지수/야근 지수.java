import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }
        
        for (int i = 0; i < n; i++) {
            pq.add(Math.max(0, pq.poll()-1));
        }
        
        long answer = 0;
        for (int i : pq) {
            answer += i*i;
        }
        
        
        return answer;
    }
}