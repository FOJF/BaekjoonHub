import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
            q.add(new int[]{i, priorities[i]});
            pq.add(priorities[i]);
        }

        int answer = 0;
        
        while(true) {
            int next = pq.poll();
            while(next != q.peek()[1]) {
                q.add(q.poll());
            }
            answer++;
            if (location == q.poll()[0]) break;
        }
        
        return answer;
    }
}